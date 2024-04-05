package com.africa.semicolon.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document
public class PasswordEntry {
    @Id
    private String name;
    private String password;
    private String username;
    private LocalDateTime dateCreated = LocalDateTime.now();
}
