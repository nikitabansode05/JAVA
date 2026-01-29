package com.jwt.authentication.filter;

import java.io.IOException;
import java.util.List;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.jwt.authentication.util.*;

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
            String header= request.getHeader("Authorization");

            if(header!=null && header.startsWith("Bearer")){
                try {
                    String token = header.substring(7);//remove word bearer and give pure token
                    String username = jwtUtil.extractUsername(token);
                    String role=jwtUtil.extractRole(token);
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
