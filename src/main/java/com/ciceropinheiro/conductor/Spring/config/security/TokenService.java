package com.ciceropinheiro.conductor.Spring.config.security;

import com.ciceropinheiro.conductor.Spring.dto.request.ClienteRequest;
import com.ciceropinheiro.conductor.Spring.model.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Base64;
import java.util.Date;

@Service
public class TokenService {
	
	@Value("${Spring.jwt.expiration}")
	private String expiration;
	
	@Value("${Spring.jwt.secret}")
	private String secret;

	public String gerarToken(Authentication authentication) {
		Usuario logado = (Usuario) authentication.getPrincipal();

		return Jwts.builder()
				.setSubject(logado.getId().toString())
				.signWith(SignatureAlgorithm.HS256, secret)
				.compact();
	}
	
	public boolean isTokenValido(String token) {
		try {
			Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Long getIdUsuario(String token) {
		Claims claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
		return Long.parseLong(claims.getSubject());
	}

}
