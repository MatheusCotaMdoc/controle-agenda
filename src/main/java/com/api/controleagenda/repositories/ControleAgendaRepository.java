package com.api.controleagenda.repositories;

import com.api.controleagenda.models.ControleAgendaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.UUID;

public interface ControleAgendaRepository extends JpaRepository<ControleAgendaModel, UUID> {

    boolean existsByNomeDoCompromisso(String nomeDoCompromisso);

    @Query(value = """
            select EXISTS (
              SELECT id
              FROM tb_controle_agenda tca
              WHERE
              	data_compromisso_inicio = :inicio or data_compromisso_fim = :inicio or
              	data_compromisso_inicio = :fim or data_compromisso_fim = :fim or
              	(:inicio between data_compromisso_inicio and data_compromisso_fim) or
            	(:fim between data_compromisso_inicio and data_compromisso_fim)
              	)
            """, nativeQuery = true)
    boolean existeCompromissoNoMesmoIntervalo(@Param("inicio") LocalDateTime inicio, @Param("fim") LocalDateTime fim);
}


