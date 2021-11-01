package com.ciceropinheiro.conductor.Spring.model;

import com.ciceropinheiro.conductor.Spring.dto.request.ClienteRequest;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Data
@Table(name = "tb_cliente")

public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    private String email;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "dia_vencimento")
    private Integer diaVencimento;

    @Column(name = "dia_corte")
    private Integer diaCorte;

//    @JsonIgnoreProperties({"cliente"})
//    @Column(name = "vendas")
//    @OneToMany(mappedBy = "cliente")
//    private List<Venda> vendas;

    @OneToOne(mappedBy = "cliente")
    private Usuario usuario;



}

