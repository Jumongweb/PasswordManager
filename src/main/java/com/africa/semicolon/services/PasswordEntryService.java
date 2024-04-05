package com.africa.semicolon.services;

import com.africa.semicolon.data.models.PasswordEntry;
import com.africa.semicolon.dtos.request.CreatePasswordRequest;
import com.africa.semicolon.dtos.response.CreatePasswordResponse;

import java.util.Collection;
import java.util.List;

public interface PasswordEntryService {
    CreatePasswordResponse save(CreatePasswordRequest createPasswordRequest);
    List<PasswordEntry> getPasswordFor(String username);

    PasswordEntry findPasswordBy(String name);
}
