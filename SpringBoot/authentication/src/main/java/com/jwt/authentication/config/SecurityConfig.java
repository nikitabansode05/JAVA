package com.jwt.authentication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.jwt.authentication.filter.JWTAuthFilter;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    private final JWTAuthFilter jwtFilter;

    public SecurityConfig(JWTAuthFilter jwtFilter){
        this.jwtFilter=jwtFilter;
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception{ //Security Filter Chain ->interface from Spring Security**********************
        http.csrf(csrf->csrf.disable()) //csrf= cross site request forgery, it is disabled cuz JWT is stateless 
            .sessionManagement(sm->
                sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))// spring wont create session
            .authorizeHttpRequests(auth-> //define who can access what
                auth.requestMatchers("/auth/**").permitAll() //req-match -> matches url, permit all ->allow access without authentication
                .anyRequest().authenticated())
            .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

            return http.build();//Finalizes configuration
                                //Creates SecurityFilterChain object
                                //Spring uses this internally
    }
}

// HttpSecurity -> inbuilt Spring Security class 
//                 used to configure security behaviour
//        Controls-CSRF,sessions,authorization,filters