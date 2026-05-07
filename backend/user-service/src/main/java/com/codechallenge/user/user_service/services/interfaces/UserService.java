package com.codechallenge.user.user_service.services;

import com.codechallenge.user.user_service.dtos.UserResponse;
import com.codechallenge.user.user_service.dtos.UserProfileRequest;
import com.codechallenge.user.user_service.dtos.UserUpdateRequest;
import java.util.List;

public interface UserService {
    void createUser(UserProfileRequest request);
    UserResponse getById(Long id);
    UserResponse getByEmail(String email);
    List<UserResponse> getAll();
    UserResponse update(Long id, UserUpdateRequest request);
    void delete(Long id);
    void updateStats(Long userId, Integer totalSubmissions, Integer totalAccepted);
}


