package com.codechallenge.auth.service.interfaces;

import com.codechallenge.auth.request.LoginRequest;
import com.codechallenge.auth.request.RegisterRequest;

public interface UserServiceInterface {
    Object authenticate(LoginRequest request);
    Object create(RegisterRequest request);
}