package com.codechallenge.auth.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RequestTokenRequest {
    @NotBlank(message = "RefeshToken khong duoc de trong")
    private String refreshToken;
}

