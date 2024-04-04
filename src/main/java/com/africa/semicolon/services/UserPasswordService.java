package com.africa.semicolon.services;

import com.africa.semicolon.data.models.User;
import com.africa.semicolon.data.repositories.Users;
import com.africa.semicolon.dtos.request.UserRegisterRequest;
import com.africa.semicolon.dtos.response.RegisterUserResponse;
import com.africa.semicolon.exceptions.UsernameAlreadyExistException;
import com.africa.semicolon.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.africa.semicolon.utils.Mapper.map;

@Service
public class UserPasswordService implements UserService{

    @Autowired
    private Users users;
    @Override
    public RegisterUserResponse register(UserRegisterRequest userRegisterRequest) {
        validate(userRegisterRequest.getUsername());
        User savedUser = map(userRegisterRequest);
        users.save(savedUser);
        return map(savedUser);
    }

    @Override
    public long count() {
        return users.count();
    }

    @Override
    public User findUserBy(String username) {
        User foundUser = null;
        for (User user : users.findAll()){
            if (user.getUsername().equals(username)) foundUser = user;
        }
        if (foundUser == null) throw new UserNotFoundException(String.format("%s not found", username));
        return foundUser;
    }

    @Override
    public List<User> findAllUsers() {
        return users.findAll();
    }

    @Override
    public void deleteUserBy(String username) {
        var user = findUserBy(username);
        users.delete(user);
    }

    public void validate(String username){
        for (User user : users.findAll()){
            if (user.getUsername().equals(username)) throw new UsernameAlreadyExistException(String.format("%s already exist", username));
        }
    }
}
