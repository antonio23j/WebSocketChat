package com.example.websockettest.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepoistory repository;

    public void saveUser(User user){
        user.setStatus(Status.ONLINE);
        repository.save(user);
    }

    public void disconnect(User user){
        User storedUser = repository.findById(user.getNickname()).orElse(null);
        if(storedUser != null){
            storedUser.setStatus(Status.OFFLINE);
            repository.save(storedUser);
        }
    }

    public List<User> findConnectedUsers(){
        return repository.findAllByStatus(Status.ONLINE);
    }
}
