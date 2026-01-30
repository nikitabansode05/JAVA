package com.jwt.authentication.filter;

import java.io.IOException;
import java.util.List;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.jwt.authentication.util.JWTUtil;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JWTAuthFilter extends OncePerRequestFilter{

    private final JWTUtil jwtUtil;

    public JWTAuthFilter(JWTUtil jwtUtil){
        this.jwtUtil=jwtUtil;
    }



    //runs before controller
    @Override
    protected void doFilterInternal(HttpServletRequest request,HttpServletResponse response,FilterChain filterChain)
        throws ServletException,IOException{
            System.out.println("JWT FILTER CALLED :"+request.getRequestURI());
            String header= request.getHeader("Authorization");
            System.out.println("Authorization header = " + header);

            if(header!=null && header.startsWith("Bearer ")){
                try {
                    System.out.println("Token extracted");
                    String token = header.substring(7);//remove word bearer and give pure token
                    String username = jwtUtil.extractUsername(token);
                    String role=jwtUtil.extractRole(token);

                    System.out.println("Username = " + username);
                    System.out.println("Role = " + role);

                    
                    SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_"+role);//*************************

                    if (username != null &&
                        SecurityContextHolder.getContext()
                            .getAuthentication() == null &&
                        jwtUtil.isTokenValid(token)) {

                        UsernamePasswordAuthenticationToken authToken =
                            new UsernamePasswordAuthenticationToken(
                                username,
                                null,
                                List.of(authority)
                            );

                        SecurityContextHolder.getContext()
                            .setAuthentication(authToken);
                    }

                } catch (Exception e) {
                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);// set http status 401
                    return;
                }
            }
        filterChain.doFilter(request, response);// request reach controller
    }
}
