package com.psevdo00.projectExchange.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.security.SecureRandom;
import java.util.Base64;

@Configuration
@EnableWebSecurity
public class SecurityConfig implements WebMvcConfigurer {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/**").permitAll()
                )
                //.oauth2ResourceServer(oauth2 -> oauth2.jwt(jwt -> jwt.jwkSetUri("https://auth.sevsu.ru/realms/portal/protocol/openid-connect/certs")))
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.ALWAYS) // Всегда использовать сессию
                );
        return http.build();
    }

    public void addCorsMappings (CorsRegistry registry){

        registry.addMapping("/**")
                .allowedOrigins("http://192.168.0.114:3000") // Точный адрес фронтенда
                .allowedMethods("*")
                .allowCredentials(true);// Добавьте это!

    }

}
