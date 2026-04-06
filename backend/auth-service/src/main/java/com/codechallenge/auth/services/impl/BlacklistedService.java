package com.codechallenge.auth.services.impl;

import com.codechallenge.auth.entities.BlacklistedToken;
import com.codechallenge.auth.resources.ApiResource;
import io.jsonwebtoken.Claims;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.codechallenge.auth.repositories.BlacklistedTokenRepository;
import java.time.ZoneId;
import java.util.Date;
import com.codechallenge.auth.services.JwtService;
import com.codechallenge.auth.requests.BlacklistTokenRequest;

@Service
public class BlacklistedService {
    @Autowired
    private BlacklistedTokenRepository blacklistedTokenRepository;

    @Autowired
    private JwtService jwtService;

    private static final Logger logger = LoggerFactory.getLogger(BlacklistedService.class);

    public Object create(BlacklistTokenRequest request) {
       try {
            if (blacklistedTokenRepository.existsByToken(request.getToken())) {
                return ApiResource.error("TOKEN_ALREADY_EXISTS", "Token da ton tai trong blacklist", HttpStatus.BAD_REQUEST);
            }
           Claims claims = jwtService.getAllClaimsFromToken(request.getToken());
           Long userId = Long.valueOf(claims.getSubject());
           Date expiryDate = claims.getExpiration();
           BlacklistedToken blacklistedToken = new BlacklistedToken();
           blacklistedToken.setToken(request.getToken());
           blacklistedToken.setUserId(userId);
           blacklistedToken.setExpiryDate(expiryDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
           blacklistedTokenRepository.save(blacklistedToken);
           logger.info("Them token token vao blacklist thanh cong");
           return ApiResource.<Void>builder()
                   .success(true)
                   .message("Them token token vao blacklist thanh cong")
                   .status(HttpStatus.OK)
                   .build();

       } catch (Exception e) {
           return ApiResource.error("TOKEN_ALREADY_EXISTS", e.getMessage(), HttpStatus.BAD_REQUEST);
       }
    }
}

