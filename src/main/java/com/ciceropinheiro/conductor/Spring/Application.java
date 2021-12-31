package com.ciceropinheiro.conductor.Spring;

import com.ciceropinheiro.conductor.Spring.model.Cliente;
import com.ciceropinheiro.conductor.Spring.model.User;
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

        User usuario = new User();
        usuario.setUsername("cicerogusta");
        usuario.setEmail("aluno@email.com");
        usuario.setPassword("$2a$10$sFKmbxbG4ryhwPNx/l3pgOJSt.fW1z6YcUnuE2X8APA/Z3NI/oSpq");
        usuario.setCliente(cliente);
        usuario.setRoles(null);
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

    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
