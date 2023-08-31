package com.api.controleagenda.controllers;

import com.api.controleagenda.configs.DateConfig;
import com.api.controleagenda.dtos.ControleAgendaDto;
import com.api.controleagenda.models.ControleAgendaModel;
import com.api.controleagenda.services.ControleAgendaService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/controle-agenda")
public class ControleAgendaController {
    final ControleAgendaService controleAgendaService;

    public ControleAgendaController(ControleAgendaService controleAgendaService) {
        this.controleAgendaService = controleAgendaService;
    }

    @PostMapping
    public ResponseEntity<Object>saveControleAgenda(@RequestBody @Valid ControleAgendaDto controleAgendaDto){
       if (controleAgendaService.existisByNomeDoCompromisso(controleAgendaDto.getNomeDoCompromisso())){
           return ResponseEntity.status(HttpStatus.CONFLICT).body("Este compromisso já existe!");
       }
       if (controleAgendaService.existeCompromissoNoMesmoIntervalo(controleAgendaDto)) {
           return ResponseEntity.status(HttpStatus.CONFLICT).body("Ja existe um compromisso neste horario!");
       }
        var controleAgendaModel = new ControleAgendaModel();
       BeanUtils.copyProperties(controleAgendaDto, controleAgendaModel);
       controleAgendaModel.setDataHoraRegistro(LocalDateTime.now(DateConfig.SAOPAULO_TIMEZONE));
       var savedControleAgenda = controleAgendaService.save(controleAgendaModel);
       return ResponseEntity.status(HttpStatus.CREATED).body(savedControleAgenda);
    }

    @GetMapping
    public ResponseEntity<List<ControleAgendaModel>>getAllControleAgenda(){
        return ResponseEntity.status(HttpStatus.OK).body(controleAgendaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneControleAgenda(@PathVariable(value = "id")UUID id){
        Optional<ControleAgendaModel> controleAgendaModelOptional = controleAgendaService.findByid(id);
        if (!controleAgendaModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Compromisso não encontrado!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(controleAgendaModelOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteControleAgenda(@PathVariable(value = "id")UUID id){
        Optional<ControleAgendaModel> controleAgendaModelOptional = controleAgendaService.findByid(id);
        if(!controleAgendaModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Compromisso não encontrado!");
        }
        controleAgendaService.delete(controleAgendaModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Compromisso apagado com sucesso!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateControleAgenda(@PathVariable(value = "id")UUID id, @RequestBody @Valid ControleAgendaDto controleAgendaDto){
        Optional<ControleAgendaModel> controleAgendaModelOptional = controleAgendaService.findByid(id);
        if (!controleAgendaModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Compromisso não encontrado!");
        }
        var controleAgendaModel = controleAgendaModelOptional.get();

        controleAgendaModel.setNomeDoCompromisso(controleAgendaDto.getNomeDoCompromisso());
        controleAgendaModel.setDataHoraCompromisso(controleAgendaDto.getDataHoraCompromisso());
        controleAgendaModel.setValor(controleAgendaDto.getValor());
        controleAgendaModel.setStatusCompromisso(controleAgendaDto.isStatusCompromisso());
        controleAgendaModel.setStatusPgto(controleAgendaDto.isStatusPgto());
        return ResponseEntity.status(HttpStatus.OK).body(controleAgendaService.save(controleAgendaModel));
    }




}

