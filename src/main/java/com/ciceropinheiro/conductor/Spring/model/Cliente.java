package com.ciceropinheiro.conductor.Spring.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_cliente")
@Builder
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "dia_vencimento")
    private Integer diaVencimento;

    @Column(name = "dia_corte")
    private Integer diaCorte;

    @JsonIgnoreProperties({"cliente"})
    @OneToMany(mappedBy = "cliente")
    private List<Venda> vendas;


}

