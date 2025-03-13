package com.ladielma.aeroporto.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // Função que configura as regras de acesso para a página de login
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                // Define como os usuários vao logar no sistema
                .formLogin(formLogin -> {
                    formLogin.loginPage("/login").permitAll();
                    ;
                })
                // Define as regras de acesso para as partes da aplicação
                .authorizeHttpRequests(authorizeRequests -> {
                    authorizeRequests.requestMatchers("/", "/img/**", "/signup", "/styles/**", "/js/**", "/teste")
                            .permitAll();
                    authorizeRequests.anyRequest().authenticated();

                })
                .build();
    }
}