package com.api.controleagenda.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public class ControleAgendaDto {

    @NotBlank
    private String nomeDoCompromisso;


    private String dataHoraCompromisso;

    @NotBlank
    private String valor;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss[.SSS][.SS][.S]")
    private LocalDateTime dataCompromissoInicio;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss[.SSS][.SS][.S]")
    private LocalDateTime dataCompromissoFim;


    private boolean statusCompromisso;


    private boolean statusPgto;

    public String getNomeDoCompromisso() {
        return nomeDoCompromisso;
    }

    public void setNomeDoCompromisso(String nomeDoCompromisso) {
        this.nomeDoCompromisso = nomeDoCompromisso;
    }



    public String getDataHoraCompromisso() {
        return dataHoraCompromisso;
    }

    public void setDataHoraCompromisso(String dataHoraCompromisso) {
        this.dataHoraCompromisso = dataHoraCompromisso;
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
}
