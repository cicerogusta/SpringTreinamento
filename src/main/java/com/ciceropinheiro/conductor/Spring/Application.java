package com.ciceropinheiro.conductor.Spring;

import com.ciceropinheiro.conductor.Spring.dto.request.ClienteRequest;
import com.ciceropinheiro.conductor.Spring.model.Cliente;
import com.ciceropinheiro.conductor.Spring.repository.ClienteRepository;
import com.ciceropinheiro.conductor.Spring.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
				.username("cicerogusta")
				.password("1234")
				.build();
		service.salvarCliente(cliente);
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
