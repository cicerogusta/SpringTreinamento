package com.ciceropinheiro.conductor.Spring;

import com.ciceropinheiro.conductor.Spring.dto.request.ClienteRequest;
import com.ciceropinheiro.conductor.Spring.model.Perfil;
import com.ciceropinheiro.conductor.Spring.model.Usuario;
import com.ciceropinheiro.conductor.Spring.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.Collections;

@SpringBootApplication
public class Application {
	@Autowired
	private ClienteService service;

	@PostConstruct
	public void initUsers() {
		ClienteRequest cliente = ClienteRequest
				.builder()
				.cpf("4646544")
				.diaCorte(10)
				.diaVencimento(14)
				.nome("Cícero")
				.build();
		service.salvarCliente(cliente);
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
