package com.africa.semicolon.exceptions;

public class UserNotLoggedInException extends PasswordManagerException {
    public UserNotLoggedInException(String message) {
        super(message);
    }
}
