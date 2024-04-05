package com.africa.semicolon.utils;

import com.africa.semicolon.data.models.PasswordEntry;
import com.africa.semicolon.data.models.User;
import com.africa.semicolon.dtos.request.CreatePasswordRequest;
import com.africa.semicolon.dtos.request.UserRegisterRequest;
import com.africa.semicolon.dtos.response.CreatePasswordResponse;
import com.africa.semicolon.dtos.response.RegisterUserResponse;

public class Mapper {
    public static User map(UserRegisterRequest userRegisterRequest){
        User user = new User();
        user.setFirstname(userRegisterRequest.getFirstname());
        user.setLastname(userRegisterRequest.getLastname());
        user.setUsername(userRegisterRequest.getUsername());
        user.setPassword(userRegisterRequest.getPassword());
        return user;
    }

    public static RegisterUserResponse map(User user){
        RegisterUserResponse response = new RegisterUserResponse();
        response.setId(user.getId());
        response.setUsername(user.getUsername());
        response.setFirstname(user.getFirstname());
        response.setLastname(user.getLastname());
        return response;
    }

    public static CreatePasswordResponse map(PasswordEntry passwordEntry){
        CreatePasswordResponse response = new CreatePasswordResponse();
        response.setWebsiteName(passwordEntry.getWebsiteName());
        response.setUsername(passwordEntry.getUsername());
        return response;
    }

    public static PasswordEntry map(CreatePasswordRequest createPasswordRequest){
        PasswordEntry passwordEntry = new PasswordEntry();
        passwordEntry.setUsername(createPasswordRequest.getUsername());
        passwordEntry.setWebsiteUsername(createPasswordRequest.getWebsiteUsername());
        passwordEntry.setWebsiteName(passwordEntry.getWebsiteName());
        passwordEntry.setPassword(createPasswordRequest.getPassword());
        return passwordEntry;
    }

//    public static User map(LoginRequest loginRequest){
//        User user = new User();
//        user.setUsername(loginRequest.getUsername());
//        user.setPassword(loginRequest.getPassword());
//        user.setLoggedIn(true);
//        return user;
//    }
//
//    public static User map(LogoutRequest logoutRequest){
//        User user = new User();
//        user.setUsername(logoutRequest.getUsername());
//        return user;
//    }
}
