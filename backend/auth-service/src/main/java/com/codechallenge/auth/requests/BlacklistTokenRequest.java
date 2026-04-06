package com.codechallenge.auth.requests;

import lombok.*;
import jakarta.validation.constraints.NotBlank;

@Data
public class BlacklistTokenRequest {
    @NotBlank(message = "Token khong duoc de trong")
    private String token;
}
