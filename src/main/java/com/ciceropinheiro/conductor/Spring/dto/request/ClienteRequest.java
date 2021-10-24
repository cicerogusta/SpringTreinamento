package com.ciceropinheiro.conductor.Spring.dto.request;

import com.ciceropinheiro.conductor.Spring.model.Venda;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ClienteRequest {


    private String nome;

    private String email;

    private String cpf;

    private Integer diaVencimento;

    private Integer diaCorte;



}
