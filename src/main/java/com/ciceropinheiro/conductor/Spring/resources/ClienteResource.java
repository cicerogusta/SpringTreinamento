package com.ciceropinheiro.conductor.Spring.resources;

import com.ciceropinheiro.conductor.Spring.dto.request.ClienteRequest;
import com.ciceropinheiro.conductor.Spring.dto.response.ClienteResponse;
import com.ciceropinheiro.conductor.Spring.model.Cliente;
import com.ciceropinheiro.conductor.Spring.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cliente")
//@Api(tags = "Clientes")
public class ClienteResource {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ClienteResponse cadastraCliente(@RequestBody ClienteRequest clienteRequest) {
        return clienteService.salvarCliente(clienteRequest);
    }

//    @ResponseStatus(HttpStatus.ACCEPTED)
//    @PutMapping(value = "/{id}")
//    @ApiOperation(
//            value = "Atualiza dados cliente",
//            notes = "Requer id do cliente")
//    public ClienteResponse atualizarCliente(@PathVariable Long id, @RequestBody ClienteRequest clienteAtualizado) {
//        return clienteService.editarCliente(id, clienteAtualizado);
//    }
//
    @GetMapping(value = "/{id}")
    public Cliente buscaClientePorEmail(@PathVariable String email) {
        return clienteService.recuperarClientePorEmail(email);

    }







//    @ResponseStatus(HttpStatus.ACCEPTED)
//    @DeleteMapping(value = "/{id}")
////    @ApiOperation(
////            value = "Deleta um cliente",
////            notes = "Requer id do cliente")
//    public void deletarCliente(@PathVariable Long id) {
//        clienteService.deletarCliente(id);
//    }


}







