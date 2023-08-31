package com.api.controleagenda.repositories;

import com.api.controleagenda.models.ControleAgendaModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ControleAgendaRepository extends JpaRepository<ControleAgendaModel, UUID> {

    boolean existsByNomeDoCompromisso(String nomeDoCompromisso);
}
