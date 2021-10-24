package com.ciceropinheiro.conductor.Spring.services;

import com.ciceropinheiro.conductor.Spring.dto.request.VendaRequest;
import com.ciceropinheiro.conductor.Spring.dto.response.VendaResponse;
import com.ciceropinheiro.conductor.Spring.mapper.VendaMapeamento;
import com.ciceropinheiro.conductor.Spring.model.Cliente;
import com.ciceropinheiro.conductor.Spring.model.Venda;
import com.ciceropinheiro.conductor.Spring.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private VendaMapeamento mapper;



    public VendaResponse salvarVenda(VendaRequest vendaRequest) {
        return mapper.entityForResponse(vendaRepository.save(mapper.requestForEntity(vendaRequest)));
    }


    public List<Venda> recuperarVendas() {
        return vendaRepository.findAll();
    }

    public List<Venda> recuperarVendasByIdCliente(Long id) {
        return vendaRepository.findAll().stream().filter(venda -> venda.getId().equals(id)).collect(Collectors.toList());
    }

//    public VendaResponse editarVenda(long id, VendaRequest venda) {
//        Venda entidade = vendaRepository.getOne(id);
//        updateData(entidade, mapper.requestForEntity(venda));
//        return mapper.entityForResponse(vendaRepository.save(entidade));
//    }

//    private void updateData(Venda entidade, Venda venda) {
//        entidade.setQuantidadeParcelas(venda.getQuantidadeParcelas());
//        entidade.setLancamentoVendaList(venda.getLancamentoVendaList());
//        entidade.setValor(venda.getValor());
//    }

    public void deletarVenda(Long id) {
        vendaRepository.deleteById(id);
    }

}
