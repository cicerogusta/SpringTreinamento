package com.ciceropinheiro.conductor.Spring.resources;


import com.ciceropinheiro.conductor.Spring.dto.request.ClienteRequest;
import com.ciceropinheiro.conductor.Spring.dto.request.LoginRequest;
import com.ciceropinheiro.conductor.Spring.dto.request.TokenRequest;
import com.ciceropinheiro.conductor.Spring.config.security.TokenService;
import com.ciceropinheiro.conductor.Spring.dto.request.VendaRequest;
import com.ciceropinheiro.conductor.Spring.mapper.VendaMapeamento;
import com.ciceropinheiro.conductor.Spring.model.Cliente;
import com.ciceropinheiro.conductor.Spring.model.Venda;
import com.ciceropinheiro.conductor.Spring.services.ClienteService;
import com.ciceropinheiro.conductor.Spring.services.VendaService;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager authManager;

    private final TokenService tokenService;
    @Autowired
    ClienteService clienteService;

    @Autowired
    VendaService vendaService;

    @Autowired
    VendaMapeamento vendaMapeamento;

    public AutenticacaoController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @PostMapping
    public ResponseEntity<TokenRequest> autenticar(@RequestBody @Validated LoginRequest loginRequest) {
        UsernamePasswordAuthenticationToken dadosLogin = loginRequest.converter();


        try {
            Authentication authentication = authManager.authenticate(dadosLogin);
            String token = tokenService.gerarToken(authentication);
            VendaRequest venda = VendaRequest
                    .builder()
                    .quantidadeParcelas(3)
                    .valor(new BigDecimal("299.99"))
                    .build();
            vendaService.salvarVenda(venda);
            List<Venda> vendas = new ArrayList<>();
            vendas.add(vendaMapeamento.requestForEntity(venda));

            ClienteRequest cliente = ClienteRequest
                    .builder()
                    .cpf("4646544")
                    .diaCorte(10)
                    .diaVencimento(14)
                    .nome("Cícero")
                    .email("aluno@email.com")
                    .vendas(vendas)
                    .token(Base64.encodeBase64String(token.getBytes(StandardCharsets.UTF_8)))
                    .build();
            clienteService.salvarCliente(cliente);

            return ResponseEntity.ok(new TokenRequest(token, "Bearer"));

        } catch (AuthenticationException e) {

            return ResponseEntity.badRequest().build();

        }

    }

//    @PostMapping("/gerarToken")
//    public ResponseEntity<String> gerarToken(@RequestBody @Validated Cliente cliente) {
//
//        try {
//            String token = tokenService.gerarTokenDados(cliente.get);
//            return ResponseEntity.ok(token);
//
//        }catch (AuthenticationException e) {
//
//            return ResponseEntity.badRequest().build();
//
//        }

}


