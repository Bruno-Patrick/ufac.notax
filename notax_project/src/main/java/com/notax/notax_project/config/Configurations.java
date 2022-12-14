package com.notax.notax_project.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class Configurations {
    
    @Bean
    public CorsFilter corsFilter() {

        CorsConfiguration configCors = new CorsConfiguration();
        configCors.setAllowCredentials(true);
        // configCors.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
        configCors.setAllowedMethods(Arrays.asList("*"));
        configCors.setAllowedHeaders(Arrays.asList("*"));

        UrlBasedCorsConfigurationSource configSource = new UrlBasedCorsConfigurationSource();
        configSource.registerCorsConfiguration("/**", configCors);

        return new CorsFilter(configSource);

    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.httpBasic();
        http.cors();
        http.csrf().disable();

        return http.build();
    }

}
