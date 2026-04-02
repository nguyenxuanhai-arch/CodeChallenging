package com.codechallenge.user.user_service.service;

import com.codechallenge.user.user_service.dto.UserDTO;
import com.codechallenge.user.user_service.dto.UserProfileRequest;
import com.codechallenge.user.user_service.dto.UserUpdateRequest;
import java.util.List;

public interface UserService {
    void createUser(UserProfileRequest request);
    UserDTO getById(Long id);
    UserDTO getByEmail(String email);
    List<UserDTO> getAll();
    UserDTO update(Long id, UserUpdateRequest request);
    void delete(Long id);
}


