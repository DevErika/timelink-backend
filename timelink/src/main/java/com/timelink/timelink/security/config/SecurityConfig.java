package com.timelink.timelink.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            .csrf(csrf -> csrf.disable()) // desactivado CSRF para usar Postman
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/users/**").permitAll() 
                // aquí se protegerán  endpoints
                .anyRequest().authenticated()
            )
            .formLogin(login -> login.disable())  // desactiva formulario login de Spring
            .httpBasic(basic -> basic.disable()); // desactiva auth básica

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
