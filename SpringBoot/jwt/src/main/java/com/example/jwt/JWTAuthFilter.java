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

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@Component
public class JWTAuthFilter extends OncePerRequestFilter {

    private final JWTUtil jwtUtil;

    public JWTAuthFilter(JWTUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    // @Override
    // protected void doFilterInternal(
    //     HttpServletRequest request,
    //     HttpServletResponse response,
    //     FilterChain filterChain
    // ) throws ServletException, IOException {

    //     String header = request.getHeader("Authorization");

    //     if (header != null && header.startsWith("Bearer ")) {
    //         String token = header.substring(7);
    //         // validate token using jwtUtil
    //          jwtUtil.validateTokenAndGetUsername(token);
             
    //     }

    //     filterChain.doFilter(request, response);
    // }

    @Override
protected void doFilterInternal(
        HttpServletRequest request,
        HttpServletResponse response,
        FilterChain filterChain)
        throws ServletException, IOException {

    String authHeader = request.getHeader("Authorization");

    if (authHeader != null && authHeader.startsWith("Bearer ")) {
        try {
            String token = authHeader.substring(7);
            String username = jwtUtil.extractUsername(token);

            if (username != null &&
                SecurityContextHolder.getContext()
                    .getAuthentication() == null &&
                jwtUtil.isTokenValid(token)) {

                UsernamePasswordAuthenticationToken authToken =
                    new UsernamePasswordAuthenticationToken(
                        username,
                        null,
                        List.of()
                    );

                SecurityContextHolder.getContext()
                    .setAuthentication(authToken);
            }

        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }
    }

    filterChain.doFilter(request, response);
}
}
