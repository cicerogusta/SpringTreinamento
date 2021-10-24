package com.ciceropinheiro.conductor.Spring.dto.request;

import com.ciceropinheiro.conductor.Spring.model.Cliente;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class VendaRequest {

    private Integer quantidadeParcelas;

    private BigDecimal valor;

    private Long idCliente;

}
