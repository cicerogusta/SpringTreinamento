package com.ciceropinheiro.conductor.Spring.config.security;


import com.ciceropinheiro.conductor.Spring.model.Usuario;
import com.ciceropinheiro.conductor.Spring.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AutenticacaoService implements UserDetailsService {
	
	@Autowired
	private UsuarioRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = repository.findByEmail(username);
		if (!usuario.getEmail().isEmpty()) {
			return usuario;
		}
		
		throw new UsernameNotFoundException("Dados inválidos!");
	}

}
