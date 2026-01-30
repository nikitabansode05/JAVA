package com.jwt.authentication.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.security.Keys;

import java.util.*;

import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.Claims;

@Component
public class JWTUtil {

    @Value("${jwt.secret}")
    private String secret;
    
    @Value("${jwt.issuer}")
    private String issuer;

    @Value("${jwt.expiration}")
    private long expiration;

    // TOKEN GENERATION
    public String generateToken(String username,String role){            //this method returns jwt-token-string
        try{
        return Jwts.builder()                                            //creates jwt builder object
                   .setSubject(username)                                 //set the subject (subject=to whom token belongs )
                   .claim("role",role)                                   //key value, used later for authorization and role based authentication
                   .setIssuer(issuer)                                    //define who issued the token (used to verify token source)
                   .setIssuedAt(new Date())
                   .setExpiration(new Date(System.currentTimeMillis()+expiration))
                   .signWith(Keys.hmacShaKeyFor(secret.getBytes()))     //sign with jwt , algorithm hs256
                   .compact();                                          //convert everything to jwt string

        }catch(Exception e){
            e.printStackTrace();    
            return null;
        }

    }  

    // TOKEN VALIDATION
    public boolean validateToken(String token) {
    try {
        Jwts.parserBuilder()                                            //opposite of jwt builder, break down complex code
            .setSigningKey(Keys.hmacShaKeyFor(secret.getBytes()))       // verifies token isnt tampered and its issued by your app
            .build()
            .parseClaimsJws(token);                                     //checks token format,algorithm,signature,expiration

        // If no exception is thrown → token is valid
        return true;

    } catch (JwtException e) {
        return false;
    }

    }

    public String extractUsername(String token) {
        return getClaims(token).getSubject();
    }

    public String extractRole(String token){
        return getClaims(token).get("role",String.class); //********************** */
    }
    public boolean isTokenValid(String token) {
        return getClaims(token).getExpiration()
            .after(new Date());
    }

    // private Claims getClaims(String token) {
    //     return Jwts.parserBuilder()
    //         .setSigningKey(secret.getBytes())
    //         .build()
    //         .parseClaimsJws(token)
    //         .getBody();
    // }
    private Claims getClaims(String token) {
        return Jwts.parserBuilder()
            .setSigningKey(Keys.hmacShaKeyFor(secret.getBytes()))
            .build()
            .parseClaimsJws(token)
            .getBody();
    }


}