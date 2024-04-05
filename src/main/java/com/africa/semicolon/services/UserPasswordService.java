package com.africa.semicolon.services;

import com.africa.semicolon.data.models.PasswordEntry;
import com.africa.semicolon.data.models.User;
import com.africa.semicolon.data.repositories.PasswordRepository;
import com.africa.semicolon.data.repositories.Users;
import com.africa.semicolon.dtos.request.LoginRequest;
import com.africa.semicolon.dtos.request.CreatePasswordRequest;
import com.africa.semicolon.dtos.request.LogoutRequest;
import com.africa.semicolon.dtos.request.UserRegisterRequest;
import com.africa.semicolon.dtos.response.CreatePasswordResponse;
import com.africa.semicolon.dtos.response.RegisterUserResponse;
import com.africa.semicolon.exceptions.InvalidPasswordException;
import com.africa.semicolon.exceptions.UserNotLoggedInException;
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

    @Autowired
    private PasswordRepository passwordEntries;
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
//        User foundUser = users.findUserBy(username);
//        if (foundUser == null) throw new UserNotFoundException(String.format("%s not found", username));
//        return foundUser;
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

    @Override
    public User login(LoginRequest loginRequest) {
        isValid(loginRequest);
        User user = findUserBy(loginRequest.getUsername());
        user.setLoggedIn(true);
        users.save(user);
        return user;
    }

    @Override
    public User logout(LogoutRequest logoutRequest) {
        User user = findUserBy(logoutRequest.getUsername());
        user.setLoggedIn(false);
        users.save(user);
        return user;
    }

    @Override
    public CreatePasswordResponse createPasswordEntry(CreatePasswordRequest createPasswordRequest) {
        User user = users.findUserBy(createPasswordRequest.getUsername());
        if (!(user.isLoggedIn())) throw new UserNotLoggedInException("You need to login to user this service");
        PasswordEntry passwordEntry = map(createPasswordRequest);
        CreatePasswordResponse response = map (passwordEntry);
        passwordEntries.save(passwordEntry);
        return response;
    }

    public void isValid(LoginRequest loginRequest){
        User foundUser = users.findUserBy(loginRequest.getUsername());
        if (!(foundUser.getUsername().equalsIgnoreCase(loginRequest.getUsername()))) throw new UserNotFoundException(String.format("%s does not exist", loginRequest.getUsername()));
        if (!(foundUser.getPassword().equals(loginRequest.getPassword()))) throw new InvalidPasswordException("Invalid password");
    }
//    @Override
//    public CreatePasswordResponse createPasswordEntry(String username, CreatePasswordRequest createPasswordRequest) {
//        PasswordEntry passwordEntry = new PasswordEntry();
//        passwordEntry.setWebsiteName(createPasswordRequest.getWebsiteName());
//        passwordEntry.setUsername(createPasswordRequest.getUsername());
//        passwordEntry.setPassword(createPasswordRequest.getPassword());
//        passwordEntries.save(passwordEntry);
//        User user = users.findUserBy(username);
//        List<PasswordEntry> passwordLists = user.getPasswordEntries();
//        passwordLists.add(passwordEntry);
//        user.setPasswordEntries(passwordLists);
//        users.save(user);
//        return map(passwordEntry);
//    }

//    @Override
//    public int userNumberOfPassword(String username) {
//        User user = users.findUserBy(username);
//        return user.getPasswordEntries().size();
//    }

    public void validate(String username){
        for (User user : users.findAll()){
            if (user.getUsername().equals(username)) throw new UsernameAlreadyExistException(String.format("%s already exist", username));
        }
    }
}
