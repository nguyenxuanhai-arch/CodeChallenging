package com.codechallenge.user.user_service.dto;

import lombok.Data;

@Data
public class UserUpdateRequest {
    private String username;
    private String email;
    private String phone;
    private String address;
    private String avatar;
} 