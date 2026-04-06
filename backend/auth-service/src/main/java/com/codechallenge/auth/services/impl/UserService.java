package com.codechallenge.auth.services.impl;

import com.codechallenge.auth.services.interfaces.UserServiceInterface;
import com.codechallenge.auth.resources.ApiResource;
import com.codechallenge.auth.services.JwtService;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.codechallenge.auth.entities.User;
import com.codechallenge.auth.requests.LoginRequest;
import com.codechallenge.auth.resources.LoginResource;
import com.codechallenge.auth.resources.UserResource;
import com.codechallenge.auth.repositories.UserRepository;
import com.codechallenge.auth.requests.RegisterRequest;

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
                    .password(passwordEncoder.encode(request.getPassword()))
                    .build();
                    userRepository.save(payload);
            return ApiResource.ok(payload, "Đăng ký thành công");
        } catch (Exception e) {
            return ApiResource.error("REGISTER_ERROR", e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}