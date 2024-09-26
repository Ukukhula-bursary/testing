package com.ukukhula.bursaryapi.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http)
            throws Exception {

        // http.addFilterBefore(jwtAuthenticationFilter,
        //         UsernamePasswordAuthenticationFilter.class);

        // http
        //         .cors(Customizer.withDefaults())
        //         .csrf(AbstractHttpConfigurer::disable)
        //         .sessionManagement(c -> c.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        //         .formLogin(AbstractHttpConfigurer::disable)
        //         .securityMatcher("/**")
        //         .authorizeHttpRequests(auth -> auth
        //                 .anyRequest().permitAll());

        return http
        .authorizeHttpRequests(outh -> {
            outh.requestMatchers("/").permitAll();
            outh.anyRequest().authenticated();

        })
        .oauth2Login(withDefaults())
        .formLogin(withDefaults())
        .build();
    }
}
