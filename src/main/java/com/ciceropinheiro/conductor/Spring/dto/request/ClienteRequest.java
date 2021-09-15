package com.ciceropinheiro.conductor.Spring.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ClienteRequest {

    private String nome;

    private String cpf;

    private Integer diaVencimento;

   private Integer diaCorte;



}
