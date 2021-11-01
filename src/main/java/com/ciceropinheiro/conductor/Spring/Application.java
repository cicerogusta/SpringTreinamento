package com.ciceropinheiro.conductor.Spring;

import com.ciceropinheiro.conductor.Spring.config.security.TokenService;
import com.ciceropinheiro.conductor.Spring.dto.request.ClienteRequest;
import com.ciceropinheiro.conductor.Spring.model.Cliente;
import com.ciceropinheiro.conductor.Spring.model.Usuario;
import com.ciceropinheiro.conductor.Spring.services.ClienteService;
import com.ciceropinheiro.conductor.Spring.services.UsuarioService;
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

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private UsuarioService usuarioService;
//
    @PostConstruct
    public void initUsers() {
        Cliente cliente = Cliente
                .builder()
                .cpf("4646544")
                .diaCorte(10)
                .diaVencimento(14)
                .nome("Cícero")
                .email("aluno@email.com")
                .build();
        clienteService.salvarCliente(cliente);

        Usuario usuario = new Usuario();
        usuario.setEmail("aluno@email.com");
        usuario.setSenha("$2a$10$sFKmbxbG4ryhwPNx/l3pgOJSt.fW1z6YcUnuE2X8APA/Z3NI/oSpq");
        usuario.setCliente(cliente);
        usuarioService.salvar(usuario);

        Cliente cliente2 = Cliente
                .builder()
                .cpf("5354353")
                .diaCorte(10)
                .diaVencimento(14)
                .nome("João")
                .email("aluno2@email.com")
                .build();
        clienteService.salvarCliente(cliente2);

        Usuario usuario2 = new Usuario();
        usuario2.setEmail("aluno2@email.com");
        usuario2.setSenha("$2a$10$sFKmbxbG4ryhwPNx/l3pgOJSt.fW1z6YcUnuE2X8APA/Z3NI/oSpq");
        usuario2.setCliente(cliente2);
        usuarioService.salvar(usuario2);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
