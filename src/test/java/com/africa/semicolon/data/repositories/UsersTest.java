package com.africa.semicolon.data.repositories;

import com.africa.semicolon.data.models.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import static org.junit.jupiter.api.Assertions.*;

@DataMongoTest
public class UsersTest {
    @Autowired
    private Users users;

    @Test
    public void testThatUserRepositoryCanSavePasswordEntry(){
        User user = new User();
        users.save(user);
        assertEquals(1,users.count());
    }
}