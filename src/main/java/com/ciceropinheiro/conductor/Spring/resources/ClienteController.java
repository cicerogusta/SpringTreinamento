package com.ciceropinheiro.conductor.Spring.resources;

import com.ciceropinheiro.conductor.Spring.dto.request.ClienteRequest;
import com.ciceropinheiro.conductor.Spring.dto.response.ClienteResponse;
import com.ciceropinheiro.conductor.Spring.model.Cliente;
import com.ciceropinheiro.conductor.Spring.services.ClienteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@Api(tags = "Clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    @ApiOperation(value = "Cadastra um cliente", notes = "Requer dados do cliente")
    public ClienteResponse salvarCliente(@RequestBody ClienteRequest cliente) {
        return clienteService.salvarCliente(cliente);
    }


    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping(value = "/{id}")
    @ApiOperation(
            value = "Atualiza dados cliente",
            notes = "Requer id do cliente")
    public ClienteResponse atualizarCliente(@PathVariable Long id, @RequestBody ClienteRequest clienteAtualizado) {
        return clienteService.editarCliente(id, clienteAtualizado);
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    @ApiOperation(
            value = "Busca clientes do banco")
    public List<Cliente> recuperarClientes() {
        return clienteService.recuperarClientes();
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{id}")
    @ApiOperation(
            value = "Recupera um cliente por id",
            notes = "Requer id do cliente")
    public Cliente recuperarClienteById(@PathVariable Long id) {
        return clienteService.recuperarClienteById(id);
    }


    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping(value = "/{id}")
    @ApiOperation(
            value = "Deleta um cliente",
            notes = "Requer id do cliente")
    public void deletarCliente(@PathVariable Long id) {
        clienteService.deletarCliente(id);
    }

    }






