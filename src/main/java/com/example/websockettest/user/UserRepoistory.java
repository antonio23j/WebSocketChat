package com.example.websockettest.user;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepoistory extends MongoRepository<User, String> {
    List<User> findAllByStatus(Status status);
}
