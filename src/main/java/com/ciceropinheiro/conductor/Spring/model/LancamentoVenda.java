package com.ciceropinheiro.conductor.Spring.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_lancamento")
@Builder
public class LancamentoVenda  {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "valor")
    private BigDecimal valor;

    @Column(name = "quantidade_parcelas")
    private Integer numeroParcela;

    @Column(name = "dia_vencimento")
    private LocalDate dataVencimento;

    @Column(name = "valor_parcela")
    private BigDecimal valorParcela;

    @JsonIgnoreProperties({"lancamentoVendaList"})
    @ManyToOne
    @JoinColumn(name = "venda_id")
    private Venda venda;

}
