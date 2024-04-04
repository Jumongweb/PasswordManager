package com.africa.semicolon.services;

import com.africa.semicolon.data.models.User;
import com.africa.semicolon.data.repositories.Users;
import com.africa.semicolon.dtos.request.UserRegisterRequest;
import com.africa.semicolon.dtos.response.RegisterUserResponse;
import com.africa.semicolon.exceptions.UserNotFoundException;
import com.africa.semicolon.exceptions.UsernameAlreadyExistException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserPasswordServiceTest {
    @Autowired
    private UserService userService;

    @Autowired
    private Users users;

    @BeforeEach
    public void setUp(){
        users.deleteAll();
    }
    @Test
    public void testThatUserServiceCanCreateUser(){
        UserRegisterRequest registerRequest = new UserRegisterRequest();
        registerRequest.setFirstname("firstname");
        registerRequest.setLastname("lastname");
        registerRequest.setUsername("username");
        registerRequest.setPassword("password");
        userService.register(registerRequest);
        assertEquals(1, userService.count());
    }

    @Test
    public void testRegister3UserUserServiceCountIs3(){
        assertEquals(0, userService.count());
        UserRegisterRequest registerRequest1 = new UserRegisterRequest();
        registerRequest1.setFirstname("firstname1");
        registerRequest1.setLastname("lastname1");
        registerRequest1.setUsername("username1");
        registerRequest1.setPassword("password1");
        userService.register(registerRequest1);
        UserRegisterRequest registerRequest2 = new UserRegisterRequest();
        registerRequest2.setFirstname("firstname2");
        registerRequest2.setLastname("lastname2");
        registerRequest2.setUsername("username2");
        registerRequest2.setPassword("password2");
        userService.register(registerRequest2);
        UserRegisterRequest registerRequest3 = new UserRegisterRequest();
        registerRequest3.setFirstname("firstname3");
        registerRequest3.setLastname("lastname3");
        registerRequest3.setUsername("username3");
        registerRequest3.setPassword("password3");
        userService.register(registerRequest3);
        assertEquals(3, userService.count());
    }

    @Test
    public void testThatUserServiceCanFindUser(){
        UserRegisterRequest registerRequest1 = new UserRegisterRequest();
        registerRequest1.setFirstname("firstname1");
        registerRequest1.setLastname("lastname1");
        registerRequest1.setUsername("username1");
        registerRequest1.setPassword("password1");
        userService.register(registerRequest1);
        assertEquals(1, userService.count());
        User foundUser = userService.findUserBy("username1");
        assertEquals("firstname1", foundUser.getFirstname());
    }

    @Test
    public void testThatUserServiceThrowExceptionIfUserThatDoesNotExistIsSearchedFor(){
        UserRegisterRequest registerRequest = new UserRegisterRequest();
        registerRequest.setFirstname("firstname");
        registerRequest.setLastname("lastname");
        registerRequest.setUsername("username");
        registerRequest.setPassword("password");
        userService.register(registerRequest);
        assertThrows(UserNotFoundException.class, ()->userService.findUserBy("wrongUsername"));
    }

    @Test
    public void testThatUserServiceCannotSaveUserWithTheSameUsername(){
        UserRegisterRequest userRegisterRequest1 = new UserRegisterRequest();
        userRegisterRequest1.setFirstname("firstname");
        userRegisterRequest1.setLastname("lastname");
        userRegisterRequest1.setUsername("username");
        userRegisterRequest1.setPassword("password");
        userService.register(userRegisterRequest1);
        UserRegisterRequest userRegisterRequest2 = new UserRegisterRequest();
        userRegisterRequest2.setFirstname("firstname");
        userRegisterRequest2.setLastname("lastname");
        userRegisterRequest2.setUsername("username");
        userRegisterRequest2.setPassword("password");
        assertThrows(UsernameAlreadyExistException.class, ()->userService.register(userRegisterRequest2));
        assertEquals(1, userService.count());
    }

    @Test
    public void testThatUserServiceCanFindAllUser(){
        UserRegisterRequest userRegisterRequest = new UserRegisterRequest();
        userRegisterRequest.setFirstname("firstname1");
        userRegisterRequest.setLastname("lastname1");
        userRegisterRequest.setUsername("username1");
        userRegisterRequest.setPassword("password1");
        userService.register(userRegisterRequest);
        UserRegisterRequest userRegisterRequest1 = new UserRegisterRequest();
        userRegisterRequest1.setFirstname("firstname2");
        userRegisterRequest1.setLastname("lastname2");
        userRegisterRequest1.setUsername("username2");
        userRegisterRequest1.setPassword("password2");
        userService.register(userRegisterRequest1);
        UserRegisterRequest userRegisterRequest2 = new UserRegisterRequest();
        userRegisterRequest2.setFirstname("firstname3");
        userRegisterRequest2.setLastname("lastname3");
        userRegisterRequest2.setUsername("username3");
        userRegisterRequest2.setPassword("password3");
        userService.register(userRegisterRequest2);
        List<User> sample = new ArrayList<>();
        sample.add(userService.findUserBy("username1"));
        sample.add(userService.findUserBy("username2"));
        sample.add(userService.findUserBy("username3"));
        assertEquals(userService.findAllUsers(), sample);
    }

}