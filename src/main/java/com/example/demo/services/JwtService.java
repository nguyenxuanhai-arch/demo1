package com.example.demo.services;

import java.security.Key;
import java.util.Date;
import java.util.Base64;
import org.springframework.stereotype.Service;
import com.example.demo.config.JwtConfig;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtService {

    private final JwtConfig jwtConfig;
    private final Key key;

    private JwtService(
        JwtConfig jwtConfig
        ) 
    {
        this.jwtConfig = jwtConfig;
        this.key = Keys.hmacShaKeyFor(Base64.getEncoder().encode(jwtConfig.getSecretKey().getBytes()));
    }

    public String generateToken(Long userId, String email) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + jwtConfig.getExpirationTime());

        return Jwts.builder()
            .setSubject(userId.toString())
            .setIssuedAt(now)
            .setExpiration(expiryDate)
            .claim("email", email)
            .signWith(key, SignatureAlgorithm.HS512)
            .compact();
    }
}
