package com.africa.semicolon.services;

import com.africa.semicolon.dtos.request.UserRegisterRequest;
import com.africa.semicolon.dtos.response.RegisterUserResponse;

public interface UserService {
    RegisterUserResponse register(UserRegisterRequest userRegisterRequest);

    long count();
}
