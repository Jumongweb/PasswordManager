package com.africa.semicolon.services;

import com.africa.semicolon.dtos.request.CreatePasswordRequest;
import com.africa.semicolon.dtos.response.CreatePasswordResponse;

public interface PasswordEntryService {
    CreatePasswordResponse save(CreatePasswordRequest createPasswordRequest);
}
