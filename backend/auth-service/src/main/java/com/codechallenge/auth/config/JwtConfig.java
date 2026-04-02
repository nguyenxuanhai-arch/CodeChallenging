package com.codechallenge.auth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;

@Configuration
public class JwtConfig {
    @Value("${jwt.secret}")
    private String secretKey;

    @Value("${jwt.expiration}")
    private long expirationTime;

    @Value("${jwt.expirationRefreshToken}")
    private long refreshTokenExpirationTime;

    @Value("${jwt.issuer}")
    private String issuer;

    public String getSecretKey() {
        return secretKey;
    }

    public long getExpirationTime() {
        return expirationTime;
    }

    public String getIssuer() { return issuer; }

    public long getRefreshTokenExpirationTime() {
        return refreshTokenExpirationTime;
    }
}
