package com.example.websockettest.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http//:localhost:4200")
public class UserController {

    private final UserService service;

    @MessageMapping("/user/addUser")
    @SendTo("/user/topic")
    public User add(@Payload User user){
        service.saveUser(user);
        return user;
    }

    @MessageMapping("/user/disconnectUser")
    @SendTo("/user/topic")
    public User disconnect (@Payload User user){
        service.disconnect(user);
        return user;
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> findConnectedUsers(){
         return ResponseEntity.ok(service.findConnectedUsers());
    }
}
