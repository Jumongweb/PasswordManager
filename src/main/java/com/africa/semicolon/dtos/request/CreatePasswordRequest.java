package com.africa.semicolon.dtos.request;

import lombok.Data;

@Data
public class CreatePasswordRequest {
    private String websiteName;
    private String websiteUsername;
    private String password;
    private String username;
}
