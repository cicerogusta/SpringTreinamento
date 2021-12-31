package com.ciceropinheiro.conductor.Spring.services;

import com.ciceropinheiro.conductor.Spring.model.User;
import com.ciceropinheiro.conductor.Spring.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;


    public void salvar(User usuario) {
        usuarioRepository.save(usuario);
    }
}
