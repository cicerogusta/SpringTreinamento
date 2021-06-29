package com.ciceropinheiro.conductor.Spring.services;

import com.ciceropinheiro.conductor.Spring.dto.request.VendaRequest;
import com.ciceropinheiro.conductor.Spring.dto.response.VendaResponse;
import com.ciceropinheiro.conductor.Spring.mapper.VendaMapeamento;
import com.ciceropinheiro.conductor.Spring.model.Venda;
import com.ciceropinheiro.conductor.Spring.repository.VendaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class VendaService {

    private final VendaRepository vendaRepository;

    private final VendaMapeamento mapper;

    public VendaService(VendaMapeamento mapper, VendaRepository vendaRepository) {
        this.mapper = mapper;
        this.vendaRepository = vendaRepository;
    }




    public VendaResponse salvarVendas(VendaRequest venda){
        return mapper.entityForResponse(vendaRepository.save(mapper.requestForEntity(venda)));
    }
    public List<Venda> recuperarVendas(){
        return vendaRepository.findAll();
    }
    public Venda recuperarVendasById(Long id){
        Optional<Venda> cliente = vendaRepository.findById(id);
        return cliente.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Objeto não encontrado"));

    }

    public VendaResponse editarVenda(long id,VendaRequest venda) {
        Venda entidade = vendaRepository.getOne(id);
        updateData(entidade,mapper.requestForEntity(venda));
        return mapper.entityForResponse(vendaRepository.save(entidade));
    }

    private void updateData(Venda entidade, Venda venda) {
        entidade.setQuantidadeParcelas(venda.getQuantidadeParcelas());
        entidade.setLancamentoVendaList(venda.getLancamentoVendaList());
        entidade.setValor(venda.getValor());
    }

    public void deletarCliente(Long id) {
        vendaRepository.deleteById(id);
    }

}
