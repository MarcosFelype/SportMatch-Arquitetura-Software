package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.model.Competicao;
import com.example.demo.repository.CompeticaoRepository;
import com.example.demo.repository.SportsSpaceRepository;

@Service
public class CompeticaoService {

    @Autowired
    private CompeticaoRepository competicaoRepository;

    @Autowired
    private SportsSpaceRepository sportsSpaceRepository;
    
    public Competicao criarCompeticao(Competicao competicao, String perfilUsuario) throws Exception {

        if (!perfilUsuario.equalsIgnoreCase("Organizador")) {
            throw new Exception("Acesso negado: Apenas organizadores podem gerenciar competições.");
        }

        LocalDateTime agora = LocalDateTime.now();
        if (competicao.getDataInicioInscricao().isBefore(agora)) {
            throw new Exception("Erro: A data de início das inscrições não pode estar no passado.");
        }

        if (!competicao.getDataInicioInscricao().isBefore(competicao.getDataFimInscricao())) {
            throw new Exception("Erro: A data de início das inscrições deve ser anterior ao término.");
        }

        if (competicao.getDataFimInscricao().isAfter(competicao.getDataInicioCompeticao())) {
            throw new Exception("Erro: O período de inscrições deve encerrar antes do início da competição.");
        }

        if (!competicao.getDataInicioCompeticao().isBefore(competicao.getDataFimCompeticao())) {
            throw new Exception("Erro: A competição deve terminar depois de começar.");
        }

        if (competicao.getTipoEsporte().equalsIgnoreCase("Individual")) {
            if (competicao.getMaxAtletas() == null || competicao.getMaxAtletas() <= 0) {
                throw new Exception("Erro: Limite de participantes é obrigatório para esporte individual.");
            }
        } else if (competicao.getTipoEsporte().equalsIgnoreCase("Coletivo")) {
            if (competicao.getNumEquipes() == null || competicao.getNumEquipes() <= 0) {
                throw new Exception("Erro: Número de equipes é obrigatório.");
            }
        }
        if (competicao.getSportsSpace() == null || competicao.getSportsSpace().getId() == null) {
            throw new Exception("Erro: O local da competição (Espaço Esportivo) é obrigatório.");
        }
        
        boolean espacoExiste = sportsSpaceRepository.existsById(competicao.getSportsSpace().getId());
        if (!espacoExiste) {
            throw new Exception("Erro: O espaço esportivo informado não está cadastrado no sistema.");
        }

        competicao.setStatus("Criada");

        return competicaoRepository.save(competicao);
    }

    public List<Competicao> listarTodasCompeticoes() {
        return competicaoRepository.findAll();
    }
}