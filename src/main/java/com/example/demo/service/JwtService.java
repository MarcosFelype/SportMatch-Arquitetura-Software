package com.example.demo.service;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {
    private static final String SECRET_KEY_STRING = "12345678_87654321_87654321_12345678";
    private static final long EXPIRATION_TIME = 86400000; // 1 dia em milissegundos

    private SecretKey getSigningKey() {
        // Implementar a lógica para retornar a chave de assinatura aqui
        return Keys.hmacShaKeyFor(SECRET_KEY_STRING.getBytes(StandardCharsets.UTF_8));
    }

    public String gerarToken(String username){
        Date agora = new Date();
        Date dataExpiracao = new Date(agora.getTime() + EXPIRATION_TIME);
        

        return Jwts.builder()
        .subject(username)
        .issuedAt(agora)
        .expiration(dataExpiracao)
        .signWith(getSigningKey(), Jwts.SIG.HS256)
        .compact()
        ;
    }


}