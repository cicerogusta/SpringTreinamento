package com.ciceropinheiro.conductor.Spring.config.security;

import com.ciceropinheiro.conductor.Spring.model.Usuario;
import com.ciceropinheiro.conductor.Spring.repository.UsuarioRepository;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AutenticacaoService implements UserDetailsService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Usuario> usuario = usuarioRepository.findByEmail(email);
        if (usuario.isPresent()) {
            return usuario.get();
        }
        throw  new UsernameNotFoundException("Dados inválidos!");
    }
}
