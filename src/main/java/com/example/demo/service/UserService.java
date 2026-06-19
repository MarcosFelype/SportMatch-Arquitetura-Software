package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.domain.model.User;
import com.example.demo.repository.UserRepository;

import lombok.Data;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
@Data   
public class UserService {

    private final UserRepository userRepository;

    public User createUser(User user){
        return userRepository.save(user);
    }
}