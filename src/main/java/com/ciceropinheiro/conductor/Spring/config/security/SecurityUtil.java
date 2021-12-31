package com.ciceropinheiro.conductor.Spring.config.security;

import com.ciceropinheiro.conductor.Spring.model.User;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtil {
    public static User getUsuario() {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof User)
            return (User) principal;

        return null;

    }
}
