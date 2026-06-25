package com.example.demo.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.domain.model.User;
import com.example.demo.dto.LoginRequestDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService{
    
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;
    private final JwtService jwtService;

    public String criptografarSenha(String senhaOriginal){
        return passwordEncoder.encode(senhaOriginal);
    }

    // verifica se a senha passada condiz com o hash salvo no banco
    public boolean verificarSenha(String senhaOriginal, String senhaCriptografada){
        return passwordEncoder.matches(senhaOriginal, senhaCriptografada);
    }

    public String autenticarUsuario(LoginRequestDto loginRequestDto){
        User user = userService.getUserByEmail(loginRequestDto.getEmail());

        if (user == null) {
            throw new RuntimeException("Usuário não encontrado");
        }

        boolean senhaValida = passwordEncoder.matches(loginRequestDto.getSenha(), user.getSenha());

        if(!senhaValida){
            throw new RuntimeException("Senha inválida");
        }

        String token = jwtService.gerarToken(loginRequestDto.getEmail());

        return token;
    }
}