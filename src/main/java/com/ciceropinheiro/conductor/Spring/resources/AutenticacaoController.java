package com.ciceropinheiro.conductor.Spring.resources;


import com.ciceropinheiro.conductor.Spring.dto.request.ClienteRequest;
import com.ciceropinheiro.conductor.Spring.dto.request.LoginRequest;
import com.ciceropinheiro.conductor.Spring.dto.request.TokenRequest;
import com.ciceropinheiro.conductor.Spring.config.security.TokenService;
import com.ciceropinheiro.conductor.Spring.model.Cliente;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;


@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager authManager;

    private final TokenService tokenService;

    public AutenticacaoController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @PostMapping
    public ResponseEntity<TokenRequest> autenticar(@RequestBody @Validated LoginRequest loginRequest) {
        UsernamePasswordAuthenticationToken dadosLogin = loginRequest.converter();

        try {
            Authentication authentication = authManager.authenticate(dadosLogin);
            String token = tokenService.gerarToken(authentication);
            return ResponseEntity.ok(new TokenRequest(token, "Bearer"));

        }catch (AuthenticationException e) {

            return ResponseEntity.badRequest().build();

        }

    }

    @PostMapping("/gerarToken")
    public ResponseEntity<String> gerarToken(@RequestBody @Validated Cliente cliente) {

        try {
            String token = tokenService.gerarTokenDados(cliente.getId().toString());
            return ResponseEntity.ok(token);

        }catch (AuthenticationException e) {

            return ResponseEntity.badRequest().build();

        }

    }



//    @GetMapping(value = "/decodificar")
//    public ResponseEntity<String> decodificarToken(@RequestBody String token) {
//        String payload = token.split("//.")[1];
//        String decodificador = Base64.decodeBase64(payload,  StandardCharsets.UTF_8)
//        return ResponseEntity.ok(decodificador);
//
//    }
}
