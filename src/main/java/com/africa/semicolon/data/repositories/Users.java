package com.africa.semicolon.data.repositories;

import com.africa.semicolon.data.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Users extends MongoRepository<User, String> {

}
