package com.ciceropinheiro.conductor.Spring.dto.request;

import com.ciceropinheiro.conductor.Spring.mapper.ClienteMapper;
import com.ciceropinheiro.conductor.Spring.model.Cliente;
import com.ciceropinheiro.conductor.Spring.model.Venda;
import com.ciceropinheiro.conductor.Spring.services.ClienteService;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ClienteRequest {


    private String nome;

    private String email;

    private String token;

    private String cpf;

    private Integer diaVencimento;

    private Integer diaCorte;

    private List<Venda> vendas = new ArrayList<>();



//    public ClienteRequest(Cliente value) {
//        this.nome = value.getNome();
//        this.email = value.getEmail();
//        this.token = value.getToken();
//        this.cpf = value.getCpf();
//        this.vendas = value.getVendas();
//        this.diaVencimento = value.getDiaVencimento();
//        this.diaCorte = value.getDiaCorte();
//
//    }
}
