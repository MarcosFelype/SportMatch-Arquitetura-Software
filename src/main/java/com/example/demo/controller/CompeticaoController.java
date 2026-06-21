package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Competicao;
import com.example.demo.service.CompeticaoService;

@RestController
@RequestMapping("/api/competicoes")
public class CompeticaoController {

    @Autowired
    private CompeticaoService competicaoService;

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrarCompeticao(@RequestBody Competicao competicao, @RequestHeader("Perfil-Usuario") String perfilUsuario) {
        try {
            Competicao novaCompeticao = competicaoService.criarCompeticao(competicao, perfilUsuario);
            return new ResponseEntity<>(novaCompeticao, HttpStatus.CREATED);
            
        } catch (Exception e) {
        
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}