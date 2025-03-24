package com.ladielma.aeroporto.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // Função que configura as regras de acesso para a página de login
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable())
                // Define as regras de acesso para as partes da aplicação
                .authorizeHttpRequests(authorizeRequests -> {
                    authorizeRequests

                            .requestMatchers("/", "/img/**", "/signup", "/styles/**", "/js/**", "/alterar-dados",
                                    "cadastroVoo/**",
                                    "/cadastroVoo", "/homeFunc", "/favicon.ico",
                                    "/login", "/pagamento", "/assentos", "/redefinir-senha", "voos", "sobre_passagem")
                            .permitAll()
                            .requestMatchers(HttpMethod.POST, "/cadastroVoo", "/cadastroVoo/**")
                            .permitAll()
                            .requestMatchers(HttpMethod.DELETE, "/homeFunc", "/homeFunc/**").permitAll();

                    authorizeRequests.anyRequest().authenticated();

                })
                .build();
    }
}