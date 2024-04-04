package com.africa.semicolon.services;

import com.africa.semicolon.data.models.User;
import com.africa.semicolon.data.repositories.Users;
import com.africa.semicolon.dtos.request.UserRegisterRequest;
import com.africa.semicolon.dtos.response.RegisterUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.africa.semicolon.utils.Mapper.map;

@Service
public class UserPasswordService implements UserService{

    @Autowired
    private Users users;
    @Override
    public RegisterUserResponse register(UserRegisterRequest userRegisterRequest) {
        //validate(userRegisterRequest.getUsername());
        User savedUser = map(userRegisterRequest);
        users.save(savedUser);
        return map(savedUser);
    }

    @Override
    public long count() {
        return users.count();
    }

//    public void validate(String username){
//        users.findUserBy(username);
//    }
}
