package com.africa.semicolon.services;

import com.africa.semicolon.data.models.PasswordEntry;
import com.africa.semicolon.data.repositories.PasswordRepository;
import com.africa.semicolon.dtos.request.CreatePasswordRequest;
import com.africa.semicolon.dtos.response.CreatePasswordResponse;
import com.africa.semicolon.exceptions.PasswordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PasswordEntryServiceImpl implements PasswordEntryService{
    @Autowired
    private PasswordRepository passwordEntries;

    @Override
    public CreatePasswordResponse save(CreatePasswordRequest createPasswordRequest) {
        return null;
    }

    @Override
    public List<PasswordEntry> getPasswordFor(String username) {
        List<PasswordEntry> passwordList = passwordEntries.findByUsername(username);
        if (passwordList.isEmpty()) throw new PasswordNotFoundException(String.format("%s not found", username));
        return passwordList;

//        for (PasswordEntry passwordEntry : passwordEntries.findAll()){
//            if (passwordEntry.getUsername().equals(username)){
//                passwordList.add(passwordEntry);
//            }
//        }

    }

    @Override
    public PasswordEntry findPasswordBy(String name) {
        PasswordEntry passwordEntry = passwordEntries.findPasswordBy(name);
        if (passwordEntry == null) throw new PasswordNotFoundException(String.format("%s does not exist", name));
        return passwordEntry;
    }

}
