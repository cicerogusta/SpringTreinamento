package com.ciceropinheiro.conductor.Spring.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_venda")
@Builder
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "quantidade_parcelas")
    private Integer quantidadeParcelas;

    private BigDecimal valor;

    @JsonIgnoreProperties({"vendas"})
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    @JsonIgnoreProperties({"venda"})
    @OneToMany(mappedBy = "venda")
    private List<LancamentoVenda> lancamentoVendaList;

}
