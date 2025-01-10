package com.quickpizza.quickpizzaorder.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenUtil {

    private final String secretKey = "your_secret_key";  // Use a more secure key

    public String generateToken(Authentication authentication) {
        String username = authentication.getName();
        
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000))  // 1 day expiry
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }
}
