package com.africa.semicolon.dtos.request;

import lombok.Data;

@Data
public class UserRegisterRequest {
    private String firstname;
    private String lastname;
    private String username;
    private String password;
}
