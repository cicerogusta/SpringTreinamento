package com.ciceropinheiro.conductor.Spring.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

;

@NoArgsConstructor
@AllArgsConstructor
@Entity
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

    @JsonIgnoreProperties({"cliente"})
    @OneToMany(mappedBy = "cliente")
    private List<Venda> vendas;

    private String token;


    public Cliente(String token) {
        this.token = token;
    }
}

