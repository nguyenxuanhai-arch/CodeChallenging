package com.codechallenge.auth.services.interfaces;

import com.codechallenge.auth.requests.LoginRequest;
import com.codechallenge.auth.requests.RegisterRequest;

public interface UserServiceInterface {
    Object authenticate(LoginRequest request);
    Object create(RegisterRequest request);
}