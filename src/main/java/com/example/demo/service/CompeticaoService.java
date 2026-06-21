package com.example.demo.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Competicao;
import com.example.demo.repository.CompeticaoRepository;

@Service
public class CompeticaoService {

    @Autowired
    private CompeticaoRepository competicaoRepository;

    public Competicao criarCompeticao(Competicao competicao, String perfilUsuario) throws Exception {

        if (!perfilUsuario.equalsIgnoreCase("Organizador")) {
            throw new Exception("Acesso negado: Apenas organizadores podem gerenciar competições.");
        }

        LocalDateTime agora = LocalDateTime.now();
        if (competicao.getDataInicioInscricao().isBefore(agora)) {
            throw new Exception("Erro (RN11): A data de início das inscrições não pode estar no passado.");
        }

        if (!competicao.getDataInicioInscricao().isBefore(competicao.getDataFimInscricao())) {
            throw new Exception("Erro (RN08): A data de início das inscrições deve ser anterior ao término.");
        }

        if (competicao.getDataFimInscricao().isAfter(competicao.getDataInicioCompeticao())) {
            throw new Exception("Erro (RN09): O período de inscrições deve encerrar antes do início da competição.");
        }

        if (!competicao.getDataInicioCompeticao().isBefore(competicao.getDataFimCompeticao())) {
            throw new Exception("Erro (RN10): A competição deve terminar depois de começar.");
        }

        if (competicao.getTipoEsporte().equalsIgnoreCase("Individual")) {
            if (competicao.getMaxAtletas() == null || competicao.getMaxAtletas() <= 0) {
                throw new Exception("Erro (RN12): Limite de participantes é obrigatório para esporte individual.");
            }
        } else if (competicao.getTipoEsporte().equalsIgnoreCase("Coletivo")) {
            if (competicao.getNumEquipes() == null || competicao.getNumEquipes() <= 0) {
                throw new Exception("Erro (RN13): Número de equipes é obrigatório.");
            }
        }

        competicao.setStatus("Criada");

        return competicaoRepository.save(competicao);
    }
}