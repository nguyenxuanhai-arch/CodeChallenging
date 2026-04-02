package com.codechallenge.user.user_service.dto;

import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private String username;
    private String email;
    private String phone;
    private String address;
    private String role;
    private String avatar;
    private String createdAt;

    public UserDTO(Long id, String username, String email, String address, String phone, String role) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.role = role;
    }

    public UserDTO() {}
}