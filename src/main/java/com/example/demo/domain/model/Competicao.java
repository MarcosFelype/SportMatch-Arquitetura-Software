package com.example.demo.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "competicoes")
@Data
@NoArgsConstructor
public class Competicao {

    @Id 
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column 
    private UUID id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String esporte;

    @Column(nullable = false)
    private String tipoEsporte; 

    @Column 
    private Integer numEquipes;

    @Column 
    private Integer minAtletasEquipe;

    @Column 
    private Integer maxAtletasEquipe;

    @Column 
    private Integer maxAtletas;

    @Column(nullable = false)
    private BigDecimal valorInscricao;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private LocalDateTime dataInicioInscricao;

    @Column(nullable = false)
    private LocalDateTime dataFimInscricao;

    @Column(nullable = false)
    private LocalDateTime dataInicioCompeticao;

    @Column(nullable = false)
    private LocalDateTime dataFimCompeticao;

    @ManyToOne
    @JoinColumn(name = "sports_space_id", nullable = false)
    private SportsSpace sportsSpace;
}