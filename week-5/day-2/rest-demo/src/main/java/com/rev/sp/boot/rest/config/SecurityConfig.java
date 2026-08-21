package com.rev.sp.boot.rest.config;

import org.springframework.security.core.userdetails.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf(csrf -> csrf.disable()).authorizeHttpRequests(
                auth-> auth
                .requestMatchers("/actuator/**").permitAll()
                .requestMatchers(
                        HttpMethod.GET,
                        "/api/v1/students/**",
                        "/api/v1/students"
                ).hasAnyRole("STUDENT", "ADMIN")
                .requestMatchers(
                        HttpMethod.POST,
                        "/api/v1/students"
                ).hasRole("ADMIN")
                .requestMatchers(
                        HttpMethod.PUT,
                        "/api/v1/students/**"
                ).hasRole("ADMIN")
                .requestMatchers(
                        HttpMethod.DELETE,
                        "/api/v1/students/**"
                ).hasRole("ADMIN")
                .anyRequest().authenticated()
        ).httpBasic(Customizer.withDefaults());
        return http.build();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        UserDetails student = User
                .withUsername("student")
                .password(passwordEncoder.encode("student123"))
                .roles("STUDENT")
                .build();

        UserDetails admin = User
                .withUsername("admin")
                .password(passwordEncoder.encode("admin123"))
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(student, admin);
    }
}
