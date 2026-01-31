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
            System.out.println("JWT FILTER CALLED :"+request.getRequestURI()); //returns the url of api
            String header= request.getHeader("Authorization");                 //get authorization header from request, the header starts with Bearer <token>
            System.out.println("Authorization header = " + header);

            if(header!=null && header.startsWith("Bearer ")){
                try {
                    System.out.println("Token extracted");
                    String token = header.substring(7);                         //remove word bearer and give pure token
                    String username = jwtUtil.extractUsername(token);
                    String role=jwtUtil.extractRole(token);

                    System.out.println("Username = " + username);
                    System.out.println("Role = " + role);

                    
                    SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_"+role);

                    if (username != null &&
                         SecurityContextHolder.getContext().getAuthentication() == null && //check if user is not authenticated already,
                        // cuz it might have been authenticated by other filter,we must avoid overwriting it,without this it may create infinite loop
                         jwtUtil.isTokenValid(token)) { //check if token is expired

                        UsernamePasswordAuthenticationToken authToken =
                            new UsernamePasswordAuthenticationToken(
                                username,               //check username
                                null,                   //password null cuz we r not checking password here
                                List.of(authority)     // checks roles
                            );

                        SecurityContextHolder.getContext() //Utility class that holds security context, getcontext return authentication object(name,password,roles)
                            .setAuthentication(authToken); //set authentication object in security context
                    }

                } catch (Exception e) {
                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);// set http status 401
                    return;
                }
            }
        filterChain.doFilter(request, response);// request reach controller
    }
}
