package com.ciceropinheiro.conductor.Spring.services;

import com.ciceropinheiro.conductor.Spring.dto.request.ClienteRequest;
import com.ciceropinheiro.conductor.Spring.dto.response.ClienteResponse;
import com.ciceropinheiro.conductor.Spring.mapper.ClienteMapper;
import com.ciceropinheiro.conductor.Spring.model.Cliente;
import com.ciceropinheiro.conductor.Spring.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class ClienteService {

    private final Cliente cliente = new Cliente();


    @Autowired
    private ClienteMapper mapper;


    @Autowired
    private ClienteRepository clienteRepository;


    public ClienteResponse salvarCliente(ClienteRequest cliente) {

        return mapper.entityForResponse(clienteRepository.save(mapper.requestForEntity(cliente)));
    }

    public Cliente recuperarClientePorId(Long id){
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return  cliente.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Objeto não encontrado"));


    }


//    public Cliente recuperarClientePorId(Long id) {
//        Optional<Cliente> cliente = clienteRepository.findById(id);
//        return cliente.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Objeto não encontrado"));
//    }

//    public Cliente recuperarClienteByToken(String email) {
//        Optional<Cliente> cliente = Optional.ofNullable(clienteRepository.findByToken(email));
//        return cliente.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Objeto não encontrado"));
//
//    }


//    public ClienteResponse editarCliente(long id, ClienteRequest cliente) {
//        Cliente entidade = clienteRepository.getOne(id);
//        updateData(entidade, mapper.requestForEntity(cliente));
//        return mapper.entityForResponse(clienteRepository.save(entidade));
//    }

//    private void updateData(Cliente entidade, Cliente cliente) {
//        entidade.setNome(cliente.getNome());
//        entidade.setCpf(cliente.getCpf());
//        entidade.setDiaVencimento(cliente.getDiaVencimento());
//    }
//
//
//    public void deletarCliente(Long id) {
//        clienteRepository.deleteById(id);
//    }


}
