package com.example.demo.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.model.InscricaoCompeticao;

@Repository
public interface InscricaoCompeticaoRepository extends JpaRepository<InscricaoCompeticao, UUID> {

}
