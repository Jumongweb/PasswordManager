package com.africa.semicolon.services;

import com.africa.semicolon.dtos.request.CreatePasswordRequest;
import com.africa.semicolon.dtos.response.CreatePasswordResponse;
import org.springframework.stereotype.Service;

@Service
public class PasswordEntryServiceImpl implements PasswordEntryService{

    @Override
    public CreatePasswordResponse save(CreatePasswordRequest createPasswordRequest) {
        return null;
    }
}
