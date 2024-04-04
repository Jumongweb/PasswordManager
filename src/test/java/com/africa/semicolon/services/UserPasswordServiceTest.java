package com.africa.semicolon.services;

import com.africa.semicolon.data.repositories.Users;
import com.africa.semicolon.dtos.request.UserRegisterRequest;
import com.africa.semicolon.dtos.response.RegisterUserResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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


}