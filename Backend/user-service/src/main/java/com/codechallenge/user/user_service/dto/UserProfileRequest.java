package com.codechallenge.user.user_service.dto;

import lombok.Data;

@Data
public class UserProfileRequest {
    private Long id;            // Id từ auth-service
    private String username;
    private String email;
    private String address;
    private String phone;
    private String role;
    private String avatar;
}
