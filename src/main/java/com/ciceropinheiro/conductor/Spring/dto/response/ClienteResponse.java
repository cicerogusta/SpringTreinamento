package com.ciceropinheiro.conductor.Spring.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ClienteResponse {

    private Long id;
    private String nome;
    private String email;
    private Integer diaVencimento;
    private Integer diaCorte;

}
