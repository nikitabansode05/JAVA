package com.example.jwt.Controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jwt.JWTUtil;
import com.example.jwt.DTO.*;

// @RestController
// @RequestMapping("/auth")
// public class AuthController {

//     private final JWTUtil jwtUtil;

//     public AuthController(JWTUtil jwtUtil) {
//         this.jwtUtil = jwtUtil;
//     }

//     @PostMapping("/login")
//     public Map<String, String> login() {

//         // Demo user
//         String token = jwtUtil.generateToken("student", "ADMIN");

//         return Map.of("token", token);
//     }
// }

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JWTUtil jwtUtil;

    public AuthController(AuthenticationManager authenticationManager,
                          JWTUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(
            @RequestBody LoginRequest request) {

        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                request.getUsername(),
                request.getPassword())
        );

        String token = jwtUtil.generateToken(
            request.getUsername());

        return ResponseEntity.ok(token);
    }
}

//token : eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzdHVkZW50Iiwicm9sZSI6IkFETUlOIiwiaXNzIjoic2VjdXJlLWFwaSIsImlhdCI6MTc2ODY2NDA5OSwiZXhwIjoxNzY4NjY1ODk5fQ.uIQgia6yEU5JBopDiXbyHMqFxxG4h9YcTZY3xttXe9Q