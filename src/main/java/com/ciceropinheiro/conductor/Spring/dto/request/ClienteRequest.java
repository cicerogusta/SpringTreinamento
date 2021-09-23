package com.ciceropinheiro.conductor.Spring.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ClienteRequest {

    private String nome;

    private Integer diaVencimento;

    private Integer diaCorte;


}
