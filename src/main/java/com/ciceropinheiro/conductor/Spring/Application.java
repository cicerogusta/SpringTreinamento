package com.ciceropinheiro.conductor.Spring;

import com.ciceropinheiro.conductor.Spring.config.security.TokenService;
import com.ciceropinheiro.conductor.Spring.dto.request.ClienteRequest;
import com.ciceropinheiro.conductor.Spring.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableSpringDataWebSupport
@EnableCaching
@EnableSwagger2
public class Application {

//    @Autowired
//    private ClienteService clienteService;

//    @Autowired
//    private TokenService tokenService;
//
//    @PostConstruct
//    public void initUsers() {
//        ClienteRequest cliente = ClienteRequest
//                .builder()
//                .cpf("4646544")
//                .diaCorte(10)
//                .diaVencimento(14)
//                .nome("Cícero")
//                .email("aluno@email.com")
//                .build();
//        clienteService.salvarCliente(cliente);
//    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
