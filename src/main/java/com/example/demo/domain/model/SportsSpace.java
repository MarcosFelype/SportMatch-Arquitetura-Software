package com.example.demo.domain.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.List;
import java.util.UUID;

@Entity(name = "sportSpace")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SportsSpace {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String tipoEspaco;
    @Column(nullable = false)
    private String capacidade;

    @Column(nullable = false)
    private String enderecoCompleto;

    @ElementCollection
    private List<String> esportesSuportados;

    @ElementCollection
    private List<String> recursos;
}