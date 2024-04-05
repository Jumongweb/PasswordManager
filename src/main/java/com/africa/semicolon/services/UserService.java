package com.africa.semicolon.services;

import com.africa.semicolon.data.models.User;
import com.africa.semicolon.dtos.request.LoginRequest;
import com.africa.semicolon.dtos.request.CreatePasswordRequest;
import com.africa.semicolon.dtos.request.LogoutRequest;
import com.africa.semicolon.dtos.request.UserRegisterRequest;
import com.africa.semicolon.dtos.response.CreatePasswordResponse;
import com.africa.semicolon.dtos.response.RegisterUserResponse;

import java.util.List;

public interface UserService {
    RegisterUserResponse register(UserRegisterRequest userRegisterRequest);

    long count();

    User findUserBy(String username);

    List<User> findAllUsers();

    void deleteUserBy(String username);

    User login(LoginRequest loginRequest);

    User logout(LogoutRequest logoutRequest);

    CreatePasswordResponse createPasswordEntry(CreatePasswordRequest createPasswordRequest);
    //CreatePasswordResponse createPasswordEntry(String username, CreatePasswordRequest createPasswordRequest);

    //int userNumberOfPassword(String username);
}
