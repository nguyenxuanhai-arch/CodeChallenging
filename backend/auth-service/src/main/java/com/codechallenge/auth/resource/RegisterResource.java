package com.codechallenge.auth.resource;

public class RegisterResource {
    private final UserResource user;

    public RegisterResource(UserResource user) {
        this.user = user;
    }
    public UserResource getUser() {
        return user;
    }
}