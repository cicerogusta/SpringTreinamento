package com.ciceropinheiro.conductor.Spring.resources;

import com.ciceropinheiro.conductor.Spring.dto.request.ClienteRequest;
import com.ciceropinheiro.conductor.Spring.dto.response.ClienteResponse;
import com.ciceropinheiro.conductor.Spring.model.Cliente;
import com.ciceropinheiro.conductor.Spring.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clientes")
//@Api(tags = "Clientes")
public class ClienteResource {

    @Autowired
    private  ClienteService clienteService;


    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping(value = "/{id}")
//    @ApiOperation(
//            value = "Atualiza dados cliente",
//            notes = "Requer id do cliente")
    public ClienteResponse atualizarCliente(@PathVariable Long id, @RequestBody ClienteRequest clienteAtualizado) {
        return clienteService.editarCliente(id, clienteAtualizado);
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{id}")
//    @ApiOperation(
//            value = "Recupera um cliente por id",
//            notes = "Requer id do cliente")
    public Cliente recuperarClienteById(@PathVariable Long id) {
        return clienteService.recuperarClienteById(id);
    }


    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping(value = "/{id}")
//    @ApiOperation(
//            value = "Deleta um cliente",
//            notes = "Requer id do cliente")
    public void deletarCliente(@PathVariable Long id) {
        clienteService.deletarCliente(id);
    }

    }






