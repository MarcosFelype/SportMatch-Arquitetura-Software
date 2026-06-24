package com.example.demo.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService{
    
    
    private final PasswordEncoder passwordEncoder;

    public String criptografarSenha(String senhaOriginal){
        return passwordEncoder.encode(senhaOriginal);
    }

    // verifica se a senha passada condiz com o hash salvo no banco
    public boolean verificarSenha(String senhaOriginal, String senhaCriptografada){
        return passwordEncoder.matches(senhaOriginal, senhaCriptografada);
    }
}