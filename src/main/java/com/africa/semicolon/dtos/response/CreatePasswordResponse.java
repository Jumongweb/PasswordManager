package com.africa.semicolon.dtos.response;

import lombok.Data;

@Data
public class CreatePasswordResponse {
    private String name;
    private String websiteUsername;
    private String username;
    private String dateCreated;
}
