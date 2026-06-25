package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.LoginRequestDto;
import com.example.demo.service.AuthService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequestDto loginRequestDto){
        try{
            String response = authService.autenticarUsuario(loginRequestDto);
            return ResponseEntity.ok(response);
        }
        catch(RuntimeException e){
            //Retorna status HTTP 401 (unauthorized) caso o Bcypt ou os dados de login falhem
            return ResponseEntity.status(401).body(e.getMessage());
        }
    }

}