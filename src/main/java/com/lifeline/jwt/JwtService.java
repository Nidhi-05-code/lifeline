package com.lifeline.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class JwtService {

    private final SecretKey key =
            Keys.hmacShaKeyFor(JwtConstants.SECRET_KEY.getBytes());

    /**
     * Generate JWT Token
     */
    public String generateToken(String email) {

        Date currentDate = new Date();

        Date expireDate = new Date(
                currentDate.getTime() + JwtConstants.JWT_EXPIRATION
        );

        return Jwts.builder()
                .subject(email)
                .issuedAt(currentDate)
                .expiration(expireDate)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    /**
     * Extract Email from JWT Token
     */
    public String extractEmail(String token) {

        return extractClaims(token).getSubject();
    }

    /**
     * Validate JWT Token
     */
    public boolean isTokenValid(String token) {

        return extractClaims(token)
                .getExpiration()
                .after(new Date());
    }

    /**
     * Extract All Claims from JWT Token
     */
    private Claims extractClaims(String token) {

        return Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }
}