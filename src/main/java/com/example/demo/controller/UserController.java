package com.example.demo.controller;

import static org.springframework.http.HttpStatus.CREATED;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.model.User;
import com.example.demo.service.AuthService;
import com.example.demo.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final AuthService authService;
    
    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){

        String senhaCriptografada = authService.criptografarSenha(user.getSenha());
        user.setSenha(senhaCriptografada);

        User createdUser = userService.createUser(user);
        return ResponseEntity.status(CREATED).body(createdUser);
    }
}
