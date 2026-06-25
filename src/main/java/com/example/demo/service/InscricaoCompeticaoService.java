package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Competicao;
import com.example.demo.domain.model.InscricaoCompeticao;
import com.example.demo.repository.CompeticaoRepository;
import com.example.demo.repository.InscricaoCompeticaoRepository;

@Service
public class InscricaoCompeticaoService {

    @Autowired
    private InscricaoCompeticaoRepository inscricaoRepository;

    @Autowired
    private CompeticaoRepository competicaoRepository;

    public InscricaoCompeticao realizarInscricao(InscricaoCompeticao inscricao, UUID competicaoId, String perfilUsuario)
            throws Exception {

        if (!perfilUsuario.equalsIgnoreCase("Atleta") && !perfilUsuario.equalsIgnoreCase("Organizador")) {
            throw new Exception("Acesso negado: Perfil de usuário inválido para realizar inscrições.");
        }

        Competicao competicao = competicaoRepository.findById(competicaoId)
                .orElseThrow(() -> new Exception("Erro: Competição não encontrada."));

        LocalDateTime agora = LocalDateTime.now();

        if (agora.isBefore(competicao.getDataInicioInscricao())) {
            throw new Exception("Erro: O período de inscrições para esta competição ainda não começou.");
        }

        if (agora.isAfter(competicao.getDataFimInscricao())) {
            throw new Exception("Erro: O período de inscrições para esta competição já foi encerrado.");
        }

        if (competicao.getTipoEsporte().equalsIgnoreCase("Individual")) {
            if (inscricao.getIntegrantes() == null || inscricao.getIntegrantes().size() != 1) {
                throw new Exception("Erro: Inscrições para esportes individuais devem conter exatamente 1 integrante.");
            }
        } else if (competicao.getTipoEsporte().equalsIgnoreCase("Coletivo")) {
            if (inscricao.getNomeEquipe() == null || inscricao.getNomeEquipe().trim().isEmpty()) {
                throw new Exception("Erro: O nome da equipe é obrigatório para esportes coletivos.");
            }
            if (inscricao.getIntegrantes() == null || inscricao.getIntegrantes().isEmpty()) {
                throw new Exception("Erro: A equipe deve possuir pelo menos 1 integrante cadastrado.");
            }
        }

        inscricao.setDataRealizacao(agora);

        if (inscricao.getFormaPagamento().equalsIgnoreCase("Gratuito")) {
            inscricao.setStatusPagamento("Confirmado");
        } else {
            inscricao.setStatusPagamento("Pendente");
        }

        return inscricaoRepository.save(inscricao);
    }
}