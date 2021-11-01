package com.ciceropinheiro.conductor.Spring.resources;


import com.ciceropinheiro.conductor.Spring.config.security.TokenService;
import com.ciceropinheiro.conductor.Spring.dto.request.LoginRequest;
import com.ciceropinheiro.conductor.Spring.dto.request.TokenRequest;
import com.ciceropinheiro.conductor.Spring.model.Cliente;
import com.ciceropinheiro.conductor.Spring.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    ClienteService clienteService;

    private final TokenService tokenService;


    public AutenticacaoController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @PostMapping
    public ResponseEntity<TokenRequest> autenticar(@RequestBody @Validated LoginRequest loginRequest) {
        UsernamePasswordAuthenticationToken dadosLogin = loginRequest.converter();


        Authentication authentication = authManager.authenticate(dadosLogin);
        String token = tokenService.gerarToken(authentication);

        Optional<Cliente> cliente = Optional.ofNullable(clienteService.recuperarClientePorEmail(loginRequest.getEmail()));
        if (cliente.isPresent()) {
            return ResponseEntity.ok(new TokenRequest(token, "Bearer"));

        }

        return ResponseEntity.badRequest().build();


    }
}


