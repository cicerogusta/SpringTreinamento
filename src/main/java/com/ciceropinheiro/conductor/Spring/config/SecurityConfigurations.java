package com.ciceropinheiro.conductor.Spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfigurations extends WebSecurityConfigurerAdapter {

    //Autenticação
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    }

    //Autorização
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(HttpMethod.GET,"/clientes/*").permitAll()
                .antMatchers(HttpMethod.GET,"/vendas/").permitAll()
                .antMatchers(HttpMethod.GET,"/vendas/*").permitAll()
                .antMatchers(HttpMethod.GET,"/lancamentos/").permitAll()
                .antMatchers(HttpMethod.GET,"/lancamentos/*").permitAll()
                .anyRequest().authenticated()
                .and().formLogin();
    }

    //Recursos estáticos(JS, CSS, IMGS)
    @Override
    public void configure(WebSecurity web) throws Exception {
    }


}
