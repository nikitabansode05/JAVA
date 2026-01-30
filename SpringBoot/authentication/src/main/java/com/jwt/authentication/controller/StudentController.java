package com.jwt.authentication.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@EnableMethodSecurity
@RestController
@RequestMapping("/api")
public class StudentController {

    @PreAuthorize("hasRole('STUDENT')")
    @GetMapping("/student")
    public String studentOnly() {
        return "Welcome Student";
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to the application!";
    }

    @PreAuthorize("hasRole('MENTOR')")
    @GetMapping("/mentor")
    public String mentorOnly() {
        return "Welcome Mentor";
    }
}



