package com.africa.semicolon.exceptions;

public class UsernameAlreadyExistException extends PasswordManagerException {
    public UsernameAlreadyExistException(String message) {
        super(message);
    }
}
