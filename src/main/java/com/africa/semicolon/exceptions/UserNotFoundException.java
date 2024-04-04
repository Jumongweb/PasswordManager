package com.africa.semicolon.exceptions;

public class UserNotFoundException extends PasswordManagerException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
