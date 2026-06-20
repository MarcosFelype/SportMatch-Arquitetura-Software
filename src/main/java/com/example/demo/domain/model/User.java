package com.example.demo.domain.model;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity(name = "users")
@Data
@NoArgsConstructor
public class User {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    @Column private String id;
    @Column private String nome;
    @Column private String cpfCnpj;
    @Column private String genero;
    @Column private String telefone;
    @Column private String nickname;
    @Column private String email;
    @Column private String senha;
    @Column private String cep;
    @Column private String endereco;
    @Column private LocalDate dataNascimento;
    @Column private String perfil;
}