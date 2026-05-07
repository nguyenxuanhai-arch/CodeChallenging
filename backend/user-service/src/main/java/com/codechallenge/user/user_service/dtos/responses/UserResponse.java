package com.codechallenge.user.user_service.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponse {
    private Long id;
    private String username;
    private String email;
    private String phone;
    private String address;
    private String role;
    private String urlAvatar;
    private Integer totalSubmissions;
    private Integer totalAccepted;
    private LocalDateTime createdAt;
}