package com.ciceropinheiro.conductor.Spring.resources;

import com.ciceropinheiro.conductor.Spring.dto.request.VendaRequest;
import com.ciceropinheiro.conductor.Spring.dto.response.VendaResponse;
import com.ciceropinheiro.conductor.Spring.model.Venda;
import com.ciceropinheiro.conductor.Spring.services.VendaService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vendas")
public class VendasResource {


    private final VendaService vendaService;

    public VendasResource(VendaService vendaService) {
        this.vendaService = vendaService;
    }


    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping(value = "/{id}")
    @ApiOperation(
            value = "Atualiza dados da venda",
            notes = "Requer id da venda")
    private VendaResponse atualizarVenda(@PathVariable Long id, @RequestBody VendaRequest novavenda) {
        return vendaService.editarVenda(id, novavenda);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    @ApiOperation(
            value = "Busca vendas do banco")
    private List<Venda> recuperarVendas() {
        return vendaService.recuperarVendas();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{id}")
    @ApiOperation(
            value = "Recupera uma venda por id",
            notes = "Requer id da venda")
    private Venda recuperarVendaById(@PathVariable Long id) {
        return vendaService.recuperarVendasById(id);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping(value = "/{id}")
    @ApiOperation(
            value = "Deleta uma vemda",
            notes = "Requer id da venda")
    public void deletarVenda(@PathVariable Long id) {
        vendaService.deletarVenda(id);
    }

}
