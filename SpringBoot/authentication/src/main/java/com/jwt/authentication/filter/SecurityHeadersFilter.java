package com.jwt.authentication.filter;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SecurityHeadersFilter extends OncePerRequestFilter{

    @Override
    protected void doFilterInternal(
        HttpServletRequest request,
        HttpServletResponse response,
        FilterChain filterChain)
         throws ServletException,IOException{

            response.setHeader("X-Frame-Options","DENY"); //clickjacking protection,never allow my site to be iframed,prevent UI redressing attacks  
            response.setHeader("X-Content-Type-Options","nosniff");//prevent MIME-type sniffing,avoid scanning attacks
            response.setHeader("Referrer-Policy","no-referrer");//prevent referrer leakage,stops leaking url,token in url

            filterChain.doFilter(request, response);
            
        }
    
}
