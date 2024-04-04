package com.africa.semicolon.services;

import com.africa.semicolon.data.models.User;
import com.africa.semicolon.dtos.request.UserRegisterRequest;
import com.africa.semicolon.dtos.response.RegisterUserResponse;

import java.util.List;

public interface UserService {
    RegisterUserResponse register(UserRegisterRequest userRegisterRequest);

    long count();

    User findUserBy(String username);

    List<User> findAllUsers();
}
