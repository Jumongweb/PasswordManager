package com.africa.semicolon.services;

import com.africa.semicolon.dtos.request.UserRegisterRequest;
import org.springframework.stereotype.Service;

@Service
public class UserPasswordService implements UserService{
    RegisterRequestResponse register(UserRegisterRequest userRegisterRequest);
}
