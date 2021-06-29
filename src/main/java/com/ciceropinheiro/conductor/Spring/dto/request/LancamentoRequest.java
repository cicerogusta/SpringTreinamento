package com.ciceropinheiro.conductor.Spring.dto.request;

import com.ciceropinheiro.conductor.Spring.model.Venda;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class LancamentoRequest {


    private BigDecimal valor;

    private Integer numeroParcela;

    private LocalDate dataVencimento;

    private Venda venda;

}
