package com.devsuperior.bds04.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
public class SecurytConfig {


    @Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

    // 1. Desabilita proteção contra CSRF (O H2 não lida bem com isso)
    http.csrf(csrf -> csrf.disable());

    // 2. Libera a visualização de Frames (O H2 usa frames HTML)
    http.headers(headers -> headers.frameOptions(frame -> frame.disable()));

    // 3. Define as autorizações
    http.authorizeHttpRequests(auth -> auth
            // Libera TOTALMENTE o acesso ao H2
            .requestMatchers(new AntPathRequestMatcher("/h2-console/**")).permitAll()
            
            .anyRequest().permitAll());

    return http.build();
}
}
