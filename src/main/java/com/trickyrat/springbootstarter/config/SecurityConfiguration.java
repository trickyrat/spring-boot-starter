package com.trickyrat.springbootstarter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;


public class SecurityConfiguration {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authz) -> authz
                        .requestMatchers("/swagger-ui/**", "/swagger-resources/**", "/profile/**", "/v3/**")
                        .permitAll()
                );
        return http.build();

    }
}
