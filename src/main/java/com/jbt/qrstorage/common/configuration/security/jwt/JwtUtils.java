package com.jbt.qrstorage.common.configuration.security.jwt;

import com.jbt.qrstorage.utils.DateTimeUtils;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Slf4j
@Component
public class JwtUtils {

    @Value("${spring.security.token.jwt-expiration-seconds}")
    private Long longTermExpiry;

    @Value("${spring.security.token.jwt-secret}")
    private String jwtSecret;

    public String generateJwtToken(String email) {
        return generateTokenFromEmail(email);
    }

    public String generateTokenFromEmail(String username) {
        SecretKey key = createKey();
        return Jwts.builder()
                .subject(username)
                .issuedAt(new Date())
                .expiration(DateTimeUtils.addSeconds(new Date(), longTermExpiry))
                .signWith(key)
                .compact();
    }

    public String getEmailFromJwtToken(String token) {
        SecretKey key = createKey();
        return Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }

    public boolean validateJwtToken(String authToken) {
        try {
            SecretKey key = createKey();
            Jwts.parser().verifyWith(key).build().parseSignedClaims(authToken);
            return true;
        } catch (SignatureException e) {
            log.error("Invalid JWT signature: {}", e.getMessage());
        } catch (MalformedJwtException e) {
            log.error("Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            log.error("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            log.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            log.error("JWT claims string is empty: {}", e.getMessage());
        }

        return false;
    }

    private SecretKey createKey() {
        return Keys.hmacShaKeyFor(jwtSecret.getBytes(StandardCharsets.UTF_8));
    }

}
