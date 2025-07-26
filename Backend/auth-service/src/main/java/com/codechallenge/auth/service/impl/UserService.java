package com.codechallenge.auth.service.impl;

import com.codechallenge.auth.service.interfaces.UserServiceInterface;
import com.codechallenge.auth.resource.ApiResource;
import com.codechallenge.auth.service.JwtService;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.codechallenge.auth.entity.User;
import com.codechallenge.auth.request.LoginRequest;
import com.codechallenge.auth.resource.LoginResource;
import com.codechallenge.auth.resource.UserResource;
import com.codechallenge.auth.repository.UserRepository;
import com.codechallenge.auth.request.RegisterRequest;

@Service
public class UserService implements UserServiceInterface {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private JwtService jwtService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Value("${jwt.defaultExpiration}")
    private long defaultExpiration;

    @Override
    public Object authenticate(LoginRequest request) {
        try {
            User user = userRepository.findByEmail(
                    request.getEmail()).orElseThrow(() -> new BadCredentialsException("Email hoac mat khau khong dung"));

            if (!passwordEncoder.matches(request.getPassword(), user.getPassword()))
            {
                throw new BadCredentialsException("Email hoac mat khau khong dung");
            }
            UserResource userResource = UserResource.builder()
                    .id(user.getId())
                    .email(user.getEmail())
                    .name(user.getName())
                    .phone(user.getPhone())
                    .build();
            String token = jwtService.generateToken(user.getId(), user.getEmail(), defaultExpiration);
            String refreshToken = jwtService.generateRefreshToken(user.getId(), user.getEmail());
            return new LoginResource(token, refreshToken, userResource);

        } catch (BadCredentialsException e)
        {
            return ApiResource.error("AUTH_ERROR", e.getMessage(), HttpStatus.UNAUTHORIZED);
        }
    }
    
    @Override
    public Object create(RegisterRequest request) {
        try {
            if (userRepository.existsByEmail(request.getEmail())) {
                return ApiResource.error("EMAIL_ALREADY_EXISTS", "Email da ton tai", HttpStatus.BAD_REQUEST);
            }
            User payload = User.builder()
                    .email(request.getEmail())
                    .name(request.getName())
                    .phone(request.getPhone())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .userCatalogueId(request.getUserCatalogId())
                    .build();
                    userRepository.save(payload);
            return ApiResource.ok(payload, "Đăng ký thành công");
        } catch (Exception e) {
            return ApiResource.error("REGISTER_ERROR", e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}