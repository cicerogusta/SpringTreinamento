package com.ciceropinheiro.conductor.Spring.resources;

import com.ciceropinheiro.conductor.Spring.dto.request.LancamentoRequest;
import com.ciceropinheiro.conductor.Spring.dto.response.LancamentoResponse;
import com.ciceropinheiro.conductor.Spring.model.LancamentoVenda;
import com.ciceropinheiro.conductor.Spring.services.LancamentoVendaService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/lancamentos")
public class LancamentoVendaController {


    @Autowired
    private LancamentoVendaService lancamentoVendaService;


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    @ApiOperation(
            value = "Cadastra um lancamento",
            notes = "Requer dados do lancamento")
    private LancamentoResponse salvarVenda(@RequestBody LancamentoRequest lancamentoVenda) {
        return lancamentoVendaService.salvarLancamentoVenda(lancamentoVenda);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping(value = "/{id}")
    @ApiOperation(
            value = "Atualiza dados de lancamento",
            notes = "Requer id do lancamento")
    private LancamentoResponse atualizarLancamentoVenda(@PathVariable Long id, @RequestBody LancamentoRequest lancamentoVenda) {
        return lancamentoVendaService.gerarAtualizacao(id, lancamentoVenda);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    @ApiOperation(
            value = "Busca lancamentos do banco")
    private List<LancamentoVenda> recuperarLancamentosVenda() {
        return lancamentoVendaService.recuperarLancamentoVenda();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{id}")
    @ApiOperation(
            value = "Recupera um lancamento por id",
            notes = "Requer id do lancamento")
    private Optional<LancamentoVenda> recuperarLancamentoVendaById(@PathVariable Long id) {
        return lancamentoVendaService.recuperarLancamentoVendaById(id);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping(value = "/{id}")
    @ApiOperation(
            value = "Deleta um lancamento",
            notes = "Requer id do lancamento")
    public void deletarVenda(@PathVariable Long id) {
        lancamentoVendaService.deletarLancamento(id);
    }
}
