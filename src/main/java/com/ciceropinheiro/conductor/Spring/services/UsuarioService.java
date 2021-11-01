package com.ciceropinheiro.conductor.Spring.services;

import com.ciceropinheiro.conductor.Spring.model.Usuario;
import com.ciceropinheiro.conductor.Spring.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;


    public void salvar(Usuario usuario) {
        usuarioRepository.save(usuario);
    }
}
