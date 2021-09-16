package com.ciceropinheiro.conductor.Spring.resources;

import com.ciceropinheiro.conductor.Spring.config.security.TokenService;
import com.ciceropinheiro.conductor.Spring.dto.request.LoginRequest;
import com.ciceropinheiro.conductor.Spring.dto.request.TokenRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Api(tags = "Autenticacao")
@RequestMapping("/auth")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager authManager;

    private final TokenService tokenService;

    public AutenticacaoController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @PostMapping
    @ApiOperation(value = "Autentica Cliente")

    public ResponseEntity<TokenRequest> autenticar(@RequestBody @Valid LoginRequest loginRequest) {
        UsernamePasswordAuthenticationToken dadosLogin = loginRequest.converter();

        try {
            Authentication authentication = authManager.authenticate(dadosLogin);
            String token = tokenService.gerarToken(authentication);
            return ResponseEntity.ok(new TokenRequest(token, "Bearer"));

        }catch (AuthenticationException e) {

            return ResponseEntity.badRequest().build();

        }

    }
}
