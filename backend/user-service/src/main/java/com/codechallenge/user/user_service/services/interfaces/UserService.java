package com.codechallenge.user.user_service.services.interfaces;

import com.codechallenge.user.user_service.dtos.responses.UserResponse;
import com.codechallenge.user.user_service.dtos.requests.UserProfileRequest;
import com.codechallenge.user.user_service.dtos.requests.UserUpdateRequest;
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


