package com.api.controleagenda.configs;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@Configuration
public class DateConfig {
    public static final String DATETIME_FORMAT = "dd-MM-yyyy'T'HH:mm:ss";
    LocalTime horaAtual = LocalTime.now(ZoneId.of("America/Sao_Paulo"));

    public static final ZoneId SAOPAULO_TIMEZONE = ZoneId.of("America/Sao_Paulo");



    public static LocalDateTimeSerializer LOCAL_DATETIME_SERIALIZAER =
            new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(DATETIME_FORMAT));

    @Bean
    @Primary
    public ObjectMapper objectMapper(){
        JavaTimeModule module = new JavaTimeModule();
        module.addSerializer(LOCAL_DATETIME_SERIALIZAER);
        return new ObjectMapper().registerModule(module);
    }
}
