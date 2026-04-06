package com.codechallenge.user.user_service.services.impl;

import com.codechallenge.user.user_service.dtos.UserResponse;
import com.codechallenge.user.user_service.dtos.UserProfileRequest;
import com.codechallenge.user.user_service.dtos.UserUpdateRequest;
import com.codechallenge.user.user_service.entities.User;
import com.codechallenge.user.user_service.exceptions.UserNotFoundException;
import com.codechallenge.user.user_service.repositories.UserRepository;
import com.codechallenge.user.user_service.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    @Transactional
    public void createUser(UserProfileRequest request) {
        if (userRepository.existsById(request.getId())) {
            log.warn("User with ID {} already exists", request.getId());
            return;
        }

        if (userRepository.existsByEmail(request.getEmail())) {
            log.warn("User with email {} already exists", request.getEmail());
            return;
        }

        User user = User.builder()
                .id(request.getId())
                .email(request.getEmail())
                .username(request.getUsername())
                .urlAvatar(request.getUrlAvatar())
                .phone(request.getPhone())
                .address(request.getAddress())
                .role(request.getRole())
                .totalSubmissions(0)
                .totalAccepted(0)
                .createdAt(LocalDateTime.now())
                .build();

        userRepository.save(user);
        log.info("User created successfully with ID: {}", user.getId());
    }

    @Override
    public UserResponse getById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with ID: " + id));
        return mapToDTO(user);
    }

    @Override
    public List<UserResponse> getAll() {
        return userRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public UserResponse update(Long id, UserUpdateRequest request) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with ID: " + id));

        if (request.getUsername() != null) {
            user.setUsername(request.getUsername());
        }
        if (request.getUrlAvatar() != null) {
            user.setUrlAvatar(request.getUrlAvatar());
        }
        if (request.getPhone() != null) {
            user.setPhone(request.getPhone());
        }
        if (request.getAddress() != null) {
            user.setAddress(request.getAddress());
        }

        User updatedUser = userRepository.save(user);
        log.info("User updated successfully with ID: {}", id);
        return mapToDTO(updatedUser);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException("User not found with ID: " + id);
        }
        userRepository.deleteById(id);
        log.info("User deleted successfully with ID: {}", id);
    }

    private UserResponse mapToDTO(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .email(user.getEmail())
                .username(user.getUsername())
                .urlAvatar(user.getUrlAvatar())
                .phone(user.getPhone())
                .address(user.getAddress())
                .role(user.getRole())
                .totalSubmissions(user.getTotalSubmissions())
                .totalAccepted(user.getTotalAccepted())
                .createdAt(user.getCreatedAt())
                .build();
    }
}
