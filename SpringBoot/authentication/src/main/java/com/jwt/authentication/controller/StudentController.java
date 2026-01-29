package com.jwt.authentication.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;

public class StudentController {

    @PreAuthorize("hasRole('student')")
    @GetMapping("/student")
    public String studentOnly() {
        return "Welcome Student";
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to the application!";
    }
}
