package com.codechallenge.auth.resource;

import lombok.*;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class RefreshTokenResource {
    private String token;
    private String refreshToken;
}

