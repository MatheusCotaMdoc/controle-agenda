package com.api.controleagenda.services;

import com.api.controleagenda.dtos.ControleAgendaDto;
import com.api.controleagenda.models.ControleAgendaModel;
import com.api.controleagenda.repositories.ControleAgendaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ControleAgendaService {

    final ControleAgendaRepository controleAgendaRepository;

    public ControleAgendaService(ControleAgendaRepository controleAgendaRepository) {
        this.controleAgendaRepository = controleAgendaRepository;
    }

    public boolean existisByNomeDoCompromisso(String nomeDoCompromisso) {
        return controleAgendaRepository.existsByNomeDoCompromisso(nomeDoCompromisso);
    }


    public ControleAgendaModel save(ControleAgendaModel controleAgendaModel) {

        return controleAgendaRepository.save(controleAgendaModel);
    }

    public List<ControleAgendaModel> findAll() {
        return controleAgendaRepository.findAll();
    }

    public Optional<ControleAgendaModel> findByid(UUID id) {
        return controleAgendaRepository.findById(id);
    }

    @Transactional
    public void delete(ControleAgendaModel controleAgendaModel){
    controleAgendaRepository.delete(controleAgendaModel);
    }

    public boolean existeCompromissoNoMesmoIntervalo(ControleAgendaDto novo){
        return controleAgendaRepository.existeCompromissoNoMesmoIntervalo(novo.getDataCompromissoInicio(), novo.getDataCompromissoFim());
    }
}
