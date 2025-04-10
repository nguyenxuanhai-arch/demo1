package com.example.demo.services;

import java.security.Key;
import java.util.Date;
import java.util.Base64;
import org.springframework.stereotype.Service;
import com.example.demo.config.JwtConfig;
import io.jsonwebtoken.security.Keys;
import java.util.function.Function;
import io.jsonwebtoken.Claims;
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

    // public String extractUsername(String token) {
    //     return extractClaim(token, Claims::getSubject);
    // }
    // private <T> T extractClaim(String token, java.util.function.Function<Claims, T> claimsResolver) {
    //     final Claims claims = extractAllClaims(token);
    //     return claimsResolver.apply(claims);
    // }

    // private Claims extractAllClaims(String token) {
    //     return Jwts.parserBuilder()
    //         .setSigningKey(key)
    //         .build()
    //         .parseClaimsJws(token)
    //         .getBody();
    // }

    public String getUserIdFromJwt(String token) {
        Claims claims = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
        return claims.getSubject();
    }
}
