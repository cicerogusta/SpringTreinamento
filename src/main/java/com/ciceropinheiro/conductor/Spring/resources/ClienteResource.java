package com.ciceropinheiro.conductor.Spring.resources;

import com.ciceropinheiro.conductor.Spring.dto.request.ClienteRequest;
import com.ciceropinheiro.conductor.Spring.dto.response.ClienteResponse;
import com.ciceropinheiro.conductor.Spring.model.Cliente;
import com.ciceropinheiro.conductor.Spring.services.ClienteService;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping("/api/clientes")
//@Api(tags = "Clientes")
public class ClienteResource {

    @Autowired
    private ClienteService clienteService;


    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping(value = "/{nomeCliente}")
//    @ApiOperation(
//            value = "Atualiza dados cliente",
//            notes = "Requer id do cliente")
    public ClienteResponse atualizarCliente(@PathVariable String nomeCliente, @RequestBody ClienteRequest clienteAtualizado) {
        return clienteService.editarCliente(nomeCliente, clienteAtualizado);
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{nomeCliente}")
//    @ApiOperation(
//            value = "Recupera um cliente por id",
//            notes = "Requer id do cliente")
    public Cliente recuperarClienteById(@PathVariable String nomeCliente) {
        return clienteService.recuperarClienteById(nomeCliente);
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






