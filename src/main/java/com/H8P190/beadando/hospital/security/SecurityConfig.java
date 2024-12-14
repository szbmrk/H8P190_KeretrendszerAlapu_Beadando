package com.H8P190.beadando.hospital.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    private final CustomUserDetailsService userDetailsService;

    public SecurityConfig(CustomUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder =
                http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(userDetailsService);
        return authenticationManagerBuilder.build();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/users/**").hasRole("ADMIN")
                        .requestMatchers("/api/patients/**").hasAnyRole("ADMIN", "DOCTOR")
                        .requestMatchers("/api/appointments/**").hasAnyRole("ADMIN", "DOCTOR")
                        .requestMatchers("/api/prescriptions/**").hasAnyRole("ADMIN", "DOCTOR")
                        .requestMatchers("/api/medications/**").hasAnyRole("ADMIN", "DOCTOR")
                        .requestMatchers("/api/medications/forPharmacist/{id}").hasRole("PHARMACIST")
                        .requestMatchers("/login", "/css/**").permitAll()
                        .requestMatchers("/profile").hasAnyRole("ADMIN", "DOCTOR", "PHARMACIST")
                        .requestMatchers("/home").hasAnyRole("ADMIN", "DOCTOR", "PHARMACIST")
                        .requestMatchers("/users/**").hasRole("ADMIN")
                        .requestMatchers("/appointments/**").hasAnyRole("ADMIN", "DOCTOR")
                        .requestMatchers("/patients/**").hasAnyRole("ADMIN", "DOCTOR")
                        .requestMatchers("/prescriptions/**").hasAnyRole("ADMIN", "DOCTOR")
                        .requestMatchers("/medications").hasAnyRole("ADMIN", "DOCTOR", "PHARMACIST")
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .loginProcessingUrl("/login")
                        .defaultSuccessUrl("/home", true)
                        .failureUrl("/login?error=true")
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login?logout=true")
                        .permitAll()
                );
        return http.build();
    }
}
