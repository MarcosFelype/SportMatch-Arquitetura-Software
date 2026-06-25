package com.example.demo.domain.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "inscricoes")
@Data
@NoArgsConstructor
public class InscricaoCompeticao {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column
    private UUID id;

    @Column
    private LocalDateTime dataRealizacao;

    @Column
    private String nomeEquipe;

    @ElementCollection
    @CollectionTable(name = "inscricao_integrantes", joinColumns = @JoinColumn(name = "inscricao_id"))
    @Column(name = "nome_integrante")
    private List<String> integrantes;

    @Column
    private String formaPagamento;

    @Column
    private String statusPagamento;
}