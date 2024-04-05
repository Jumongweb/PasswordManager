package com.africa.semicolon.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PasswordEntryServiceImplTest {
    @Autowired
    private PasswordEntryService passwordEntryService;
    @Test
    public void testThatPasswordEntryServiceCanSavePassword(){
        
    }
}