package com.africa.semicolon.utils;

import com.africa.semicolon.data.models.User;
import com.africa.semicolon.dtos.request.UserRegisterRequest;
import com.africa.semicolon.dtos.response.RegisterUserResponse;

import java.time.format.DateTimeFormatter;

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
