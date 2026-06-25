package com.example.demo.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.model.InscricaoCompeticao;
import com.example.demo.service.InscricaoCompeticaoService;

@RestController
@RequestMapping("/api/inscricoes")
public class InscricaoCompeticaoController {

    @Autowired
    private InscricaoCompeticaoService inscricaoCompeticaoService;

    @PostMapping("/inscrever/{competicaoId}")
    public ResponseEntity<?> inscreverNaCompeticao(
            @PathVariable UUID competicaoId,
            @RequestBody InscricaoCompeticao inscricao,
            @RequestHeader("Perfil-Usuario") String perfilUsuario) {
        try {
            InscricaoCompeticao novaInscricao = inscricaoCompeticaoService.realizarInscricao(inscricao, competicaoId,
                    perfilUsuario);
            return new ResponseEntity<>(novaInscricao, HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}