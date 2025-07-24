package com.codechallenge.user.user_service.service;

import com.codechallenge.user.user_service.dto.UserDTO;
import com.codechallenge.user.user_service.dto.UserUpdateRequest;
import com.codechallenge.user.user_service.dto.SubmissionHistoryDTO;
import com.codechallenge.user.user_service.entity.User;
import com.codechallenge.user.user_service.repository.UserRepository;
import com.codechallenge.user.user_service.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceIml {
    @Autowired
    private UserRepository userRepository;

    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));
        return toDTO(user);
    }
    
    public UserDTO createUser(UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setRole(userDTO.getRole());
        user.setAvatar(userDTO.getAvatar());
        userRepository.save(user);
        return toDTO(user);
    }   

    public UserDTO updateUser(Long id, UserUpdateRequest request) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));
        if (request.getUsername() != null) user.setUsername(request.getUsername());
        if (request.getAvatar() != null) user.setAvatar(request.getAvatar());
        userRepository.save(user);
        return toDTO(user);
    }

    // Tạm thời mock dữ liệu submissions, sau này sẽ gọi REST sang submission-service
    public List<SubmissionHistoryDTO> getSubmissionHistory(Long userId) {
        // TODO: Gọi REST sang submission-service
        return List.of();
    }

    private UserDTO toDTO(User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        dto.setRole(user.getRole());
        dto.setAvatar(user.getAvatar());
        dto.setCreatedAt(user.getCreatedAt() != null ? user.getCreatedAt().toString() : null);
        return dto;
    }
} 