package com.codechallenge.user.user_service.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserProfileRequest {
    
    @NotNull(message = "ID không được để trống")
    private Long id;

    @NotBlank(message = "username không được để trống")
    @Size(min = 3, max = 50, message = "username phải có độ dài từ 3 đến 50 ký tự")
    private String username;

    @NotBlank(message = "Email không được để trống")
    @Email(message = "Email phải có định dạng hợp lệ")
    private String email;

    @Size(max = 255, message = "Địa chỉ không được vượt quá 255 ký tự")
    private String address;

    @Size(max = 20, message = "Phone phải có độ dài tối đa 20 ký tự")
    private String phone;

    private String role;

    @Size(max = 500, message = "Avatar URL must not exceed 500 characters")
    private String urlAvatar;
}
