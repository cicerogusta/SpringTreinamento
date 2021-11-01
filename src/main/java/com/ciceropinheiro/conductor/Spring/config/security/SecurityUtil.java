package com.ciceropinheiro.conductor.Spring.config.security;

import com.ciceropinheiro.conductor.Spring.model.Usuario;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtil {


    public static Usuario getUsuario() {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof Usuario)
            return (Usuario) principal;

        return null;

    }
}
