package com.api.controleagenda.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "TB_CONTROLE_AGENDA")
public class ControleAgendaModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) private UUID id;

    @Column(nullable = false,unique = true, length =70)
    private String nomeDoCompromisso;

    @Column(nullable = false)
    private LocalDateTime dataHoraRegistro;

    @Column
    private String dataHoraCompromisso;



    @Column(nullable = false,length = 10)
    private String valor;

    @Column
    private boolean statusCompromisso;

    @Column
    private boolean statusPgto;

    @Column
    private LocalDateTime dataCompromissoInicio;

    @Column
    private LocalDateTime dataCompromissoFim;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNomeDoCompromisso() {
        return nomeDoCompromisso;
    }

    public void setNomeDoCompromisso(String nomeDoCompromisso) {
        this.nomeDoCompromisso = nomeDoCompromisso;
    }

    public LocalDateTime getDataHoraRegistro() {
        return dataHoraRegistro;
    }

    public void setDataHoraRegistro(LocalDateTime dataHoraRegistro) {
        this.dataHoraRegistro = dataHoraRegistro;
    }

    public String getDataHoraCompromisso() {
        return dataHoraCompromisso;
    }

    public void setDataHoraCompromisso(String dataHoraCompromisso) {
        this.dataHoraCompromisso = dataHoraCompromisso;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public boolean isStatusCompromisso() {
        return statusCompromisso;
    }

    public void setStatusCompromisso(boolean statusCompromisso) {
        this.statusCompromisso = statusCompromisso;
    }

    public boolean isStatusPgto() {
        return statusPgto;
    }

    public void setStatusPgto(boolean statusPgto) {
        this.statusPgto = statusPgto;
    }

    public LocalDateTime getDataCompromissoInicio() {
        return dataCompromissoInicio;
    }

    public void setDataCompromissoInicio(LocalDateTime dataCompromissoInicio) {
        this.dataCompromissoInicio = dataCompromissoInicio;
    }

    public LocalDateTime getDataCompromissoFim() {
        return dataCompromissoFim;
    }

    public void setDataCompromissoFim(LocalDateTime dataCompromissoFim) {
        this.dataCompromissoFim = dataCompromissoFim;
    }
}
