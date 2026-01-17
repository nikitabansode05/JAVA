// package com.example.jwt;

// import java.io.IOException;

// import org.springframework.stereotype.Component;
// import org.springframework.web.filter.OncePerRequestFilter;


// import jakarta.servlet.FilterChain;
// import jakarta.servlet.ServletException;
// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;

// @Component
// public class JWTAuthFilter extends OncePerRequestFilter {

//     private final JWTUtil jwtUtil;

//     public JWTAuthFilter(JWTUtil jwtUtil) {
//         this.jwtUtil = jwtUtil;
//     }

//     @Override
//     protected void doFilterInternal(
//         HttpServletRequest request,
//         HttpServletResponse response,
//         FilterChain filterChain)
//         throws ServletException, IOException {

//         String header = request.getHeader("Authorization");

//         if (header != null && header.startsWith("Bearer ")) {
//             // validate token (simplified)
//         }

//         filterChain.doFilter(request, response);
//     }
// }
package com.example.jwt;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@Component
public class JWTAuthFilter extends OncePerRequestFilter {

    private final JWTUtil jwtUtil;

    public JWTAuthFilter(JWTUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    protected void doFilterInternal(
        HttpServletRequest request,
        HttpServletResponse response,
        FilterChain filterChain
    ) throws ServletException, IOException {

        String header = request.getHeader("Authorization");

        if (header != null && header.startsWith("Bearer ")) {
            String token = header.substring(7);
            // validate token using jwtUtil
            // e.g., jwtUtil.validateToken(token);
        }

        filterChain.doFilter(request, response);
    }
}
