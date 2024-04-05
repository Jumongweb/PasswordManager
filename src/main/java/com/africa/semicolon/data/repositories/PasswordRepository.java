package com.africa.semicolon.data.repositories;

import com.africa.semicolon.data.models.PasswordEntry;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PasswordRepository extends MongoRepository<PasswordEntry, String> {
    List<PasswordEntry> findByUsername(String username);

    PasswordEntry findPasswordBy(String name);
}
