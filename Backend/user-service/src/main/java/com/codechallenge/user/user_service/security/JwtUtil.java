package com.codechallenge.user.user_service.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.function.Function;

@Component
public class JwtUtil {

    private final Key key;

    @Value("${jwt.issuer}")
    private String issuer;

    public JwtUtil(@Value("${jwt.secret}") String secretKey) {
        byte[] keyBytes = Base64.getEncoder().encode(secretKey.getBytes());
        this.key = Keys.hmacShaKeyFor(keyBytes);
    }

    public boolean isValidFormat(String token) {
        return token != null && token.split("\\.").length == 3;
    }

    public boolean isSignatureValid(String token) {
        try {
            parseAllClaims(token);
            return true;
        } catch (JwtException e) {
            return false;
        }
    }

    public boolean isTokenExpired(String token) {
        Date expiration = getClaim(token, Claims::getExpiration);
        return expiration.before(new Date());
    }

    public boolean isIssuerValid(String token) {
        String tokenIssuer = getClaim(token, Claims::getIssuer);
        return issuer.equals(tokenIssuer);
    }

    public String getUserId(String token) {
        return getClaim(token, Claims::getSubject);
    }

    public String getEmail(String token) {
        return getClaim(token, claims -> claims.get("email", String.class));
    }

    private Claims parseAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public <T> T getClaim(String token, Function<Claims, T> resolver) {
        return resolver.apply(parseAllClaims(token));
    }
}
