package com.example.demo.controller;

import com.example.demo.domain.model.SportsSpace;
import com.example.demo.service.SportsSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Espacos")
public class SportsSpaceController {
    @Autowired
    private SportsSpaceService service;

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody SportsSpace espaco) {
        try{
            SportsSpace novoEspaco = service.cadastrarEspaco(espaco);
            return ResponseEntity.ok().body(novoEspaco);
        }
        catch(RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
