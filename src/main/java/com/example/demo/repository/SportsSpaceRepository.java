package com.example.demo.repository;

import com.example.demo.domain.model.SportsSpace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SportsSpaceRepository extends JpaRepository<SportsSpace, UUID> {
    boolean existsByNomeAndEnderecoCompleto(String nome, String enderecoCompleto);
}
