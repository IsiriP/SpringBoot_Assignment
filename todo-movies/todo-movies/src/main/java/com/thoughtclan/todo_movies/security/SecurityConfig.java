package com.thoughtclan.todo_movies.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration
public class SecurityConfig {

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authProvider() {
        DaoAuthenticationProvider p = new DaoAuthenticationProvider();
        p.setUserDetailsService(userDetailsService);
        p.setPasswordEncoder(passwordEncoder());
        return p;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                // disable CSRF using lambda-style API
                .csrf(csrf -> csrf.disable())

                // authorization rules using new API
                .authorizeHttpRequests(auth -> auth
                        // public endpoints
                        .requestMatchers("/h2-console/**", "/api/movies/**").permitAll()
                        // authenticated endpoints
                        .requestMatchers("/api/watchlist/**").authenticated()
                        // everything else
                        .anyRequest().permitAll()
                )

                // HTTP Basic auth for simplicity (can switch to other auth methods later)
                .httpBasic(Customizer.withDefaults())

                // register authentication provider
                .authenticationProvider(authProvider());

        // Allow H2 console frames (new API)
        http.headers(headers -> headers.frameOptions(frame -> frame.disable()));

        return http.build();
    }
}
