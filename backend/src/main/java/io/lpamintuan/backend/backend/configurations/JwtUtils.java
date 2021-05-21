package io.lpamintuan.backend.backend.configurations;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.*;
import io.lpamintuan.backend.backend.user.UserDetailsImpl;

@Component
public class JwtUtils {

    private static final Logger logger  = LoggerFactory.getLogger(JwtUtils.class);

    private String jwtSecret;
    private int jwtExpirationMs;

    public String generateJwtToken(Authentication authentication) {

        UserDetailsImpl userPrincipal = (UserDetailsImpl)  authentication.getPrincipal();
        return Jwts.builder()
            .setSubject(userPrincipal.getUsername())
            .setIssuedAt(new Date())
            .setExpiration(new Date(new Date().getTime() + jwtExpirationMs))
            .signWith(SignatureAlgorithm.HS512, jwtSecret)
            .compact();

    }

    public String getUsernameFromJwtToken(String token) {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        } catch(SignatureException e) {
            logger.error("Invalid token");
        }
        return false;
    }
    
}
