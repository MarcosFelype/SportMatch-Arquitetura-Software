package com.example.demo.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "competicoes")
public class Competicao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String esporte;

    @Column(nullable = false)
    private String tipoEsporte; 

    private Integer numEquipes;
    private Integer minAtletasEquipe;
    private Integer maxAtletasEquipe;
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

    public Competicao() {}

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getEsporte() { return esporte; }
    public void setEsporte(String esporte) { this.esporte = esporte; }
    public String getTipoEsporte() { return tipoEsporte; }
    public void setTipoEsporte(String tipoEsporte) { this.tipoEsporte = tipoEsporte; }
    public Integer getNumEquipes() { return numEquipes; }
    public void setNumEquipes(Integer numEquipes) { this.numEquipes = numEquipes; }
    public Integer getMinAtletasEquipe() { return minAtletasEquipe; }
    public void setMinAtletasEquipe(Integer minAtletasEquipe) { this.minAtletasEquipe = minAtletasEquipe; }
    public Integer getMaxAtletasEquipe() { return maxAtletasEquipe; }
    public void setMaxAtletasEquipe(Integer maxAtletasEquipe) { this.maxAtletasEquipe = maxAtletasEquipe; }
    public Integer getMaxAtletas() { return maxAtletas; }
    public void setMaxAtletas(Integer maxAtletas) { this.maxAtletas = maxAtletas; }
    public BigDecimal getValorInscricao() { return valorInscricao; }
    public void setValorInscricao(BigDecimal valorInscricao) { this.valorInscricao = valorInscricao; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public LocalDateTime getDataInicioInscricao() { return dataInicioInscricao; }
    public void setDataInicioInscricao(LocalDateTime dataInicioInscricao) { this.dataInicioInscricao = dataInicioInscricao; }
    public LocalDateTime getDataFimInscricao() { return dataFimInscricao; }
    public void setDataFimInscricao(LocalDateTime dataFimInscricao) { this.dataFimInscricao = dataFimInscricao; }
    public LocalDateTime getDataInicioCompeticao() { return dataInicioCompeticao; }
    public void setDataInicioCompeticao(LocalDateTime dataInicioCompeticao) { this.dataInicioCompeticao = dataInicioCompeticao; }
    public LocalDateTime getDataFimCompeticao() { return dataFimCompeticao; }
    public void setDataFimCompeticao(LocalDateTime dataFimCompeticao) { this.dataFimCompeticao = dataFimCompeticao; }
}