package com.ciceropinheiro.conductor.Spring.resources;

import com.ciceropinheiro.conductor.Spring.dto.request.VendaRequest;
import com.ciceropinheiro.conductor.Spring.dto.response.VendaResponse;
import com.ciceropinheiro.conductor.Spring.model.Cliente;
import com.ciceropinheiro.conductor.Spring.model.LancamentoVenda;
import com.ciceropinheiro.conductor.Spring.model.Venda;
import com.ciceropinheiro.conductor.Spring.repository.ClienteRepository;
import com.ciceropinheiro.conductor.Spring.repository.VendaRepository;
import com.ciceropinheiro.conductor.Spring.services.VendaService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/vendas")
public class VendasResource {


    private final VendaService vendaService;
    @Autowired
    ClienteRepository clienteRepository;

    public VendasResource(VendaService vendaService) {
        this.vendaService = vendaService;
    }


    @PostMapping
    private VendaResponse cadastraVenda(@RequestBody VendaRequest vendaRequest) {
        return vendaService.salvarVenda(vendaRequest);
    }

    @GetMapping(value = "/{id}")
    private List<Venda> retornaVendaClienteByClienteId(@PathVariable Long id) {
        return vendaService.recuperarVendasByIdCliente(id);
    }


//    @ResponseStatus(HttpStatus.ACCEPTED)
//    @PutMapping(value = "/{id}")
//    @ApiOperation(
//            value = "Atualiza dados da venda",
//            notes = "Requer id da venda")
//    private VendaResponse atualizarVenda(@PathVariable Long id, @RequestBody VendaRequest novavenda) {
//        return vendaService.editarVenda(id, novavenda);
//    }


//    @ResponseStatus(HttpStatus.OK)
//    @GetMapping(value = "/{id}")
//    @ApiOperation(
//            value = "Recupera uma venda por id",
//            notes = "Requer id da venda")
//    private List<LancamentoVenda> recuperarVendaById(@PathVariable Long id) {
//        List<LancamentoVenda> listaLancamentos = new ArrayList<>();
//        List<Venda> listaVenda = vendaService.recuperarVendasById(id);
//        for (Venda venda : listaVenda) {
//            listaLancamentos.addAll(venda.getLancamentoVendaList());
//        }
//        return listaLancamentos;
//
//    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping(value = "/{id}")
    @ApiOperation(
            value = "Deleta uma vemda",
            notes = "Requer id da venda")
    public void deletarVenda(@PathVariable Long id) {
        vendaService.deletarVenda(id);
    }

}
