package com.example.jwt.Controller;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jwt.JWTUtil;


@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JWTUtil jwtUtil;

    public AuthController(JWTUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public Map<String, String> login() {

        // Demo user
        String token = jwtUtil.generateToken("student", "ADMIN");

        return Map.of("token", token);
    }
}


//token : eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzdHVkZW50Iiwicm9sZSI6IkFETUlOIiwiaXNzIjoic2VjdXJlLWFwaSIsImlhdCI6MTc2ODY2NDA5OSwiZXhwIjoxNzY4NjY1ODk5fQ.uIQgia6yEU5JBopDiXbyHMqFxxG4h9YcTZY3xttXe9Q