package com.africa.semicolon.dtos.response;

import lombok.Data;

@Data
public class RegisterUserResponse {
    private String id;
    private String username;
    private String firstname;
    private String lastname;
}
