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
                // Define as regras de acesso para as partes da aplicação
                .authorizeHttpRequests(authorizeRequests -> {
                    authorizeRequests
                            .requestMatchers("/", "/img/**", "/signup", "/styles/**", "/js/**", "/alterar-dados",
                                    "/login", "/pagamento", "/assentos")
                            .permitAll();
                    authorizeRequests.anyRequest().authenticated();

                })
                .build();
    }
}