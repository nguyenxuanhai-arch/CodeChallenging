package com.codechallenge.user.user_service.service;

import com.codechallenge.user.user_service.dto.UserDTO;
import com.codechallenge.user.user_service.dto.UserUpdateRequest;
import com.codechallenge.user.user_service.dto.SubmissionHistoryDTO;
import java.util.List;

public interface UserService {
    UserDTO getUserById(Long id);
    List<UserDTO> getAllUsers();
    UserDTO createUser(UserDTO userDTO);
    UserDTO updateUser(Long id, UserUpdateRequest request);
    void deleteUser(Long id);
    List<SubmissionHistoryDTO> getSubmissionHistory(Long userId);
}

