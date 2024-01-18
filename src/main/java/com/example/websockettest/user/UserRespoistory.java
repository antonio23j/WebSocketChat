package com.example.websockettest.user;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRespoistory extends MongoRepository<User, String> {
    List<User> findAllByStatus(Status status);
}
