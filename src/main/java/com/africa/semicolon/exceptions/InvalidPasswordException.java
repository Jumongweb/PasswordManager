package com.africa.semicolon.exceptions;

public class InvalidPasswordException extends PasswordManagerException{
    public InvalidPasswordException(String message){
        super(message);
    }
}
