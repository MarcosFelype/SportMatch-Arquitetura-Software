package com.example.demo.service;

import com.example.demo.domain.model.SportsSpace;
import com.example.demo.repository.SportsSpaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SportsSpaceService {

    @Autowired
    private SportsSpaceRepository repository;

    public SportsSpace cadastrarEspaco(SportsSpace espaco) {
        boolean existencia = repository.existsByNomeAndEnderecoCompleto(espaco.getNome(), espaco.getEnderecoCompleto());
        if (existencia) {
            throw new RuntimeException("Regra de Negócio RN40: Já existe um espaço esportivo cadastrado com este nome e endereço!");
        }
        return repository.save(espaco);
    }
}
