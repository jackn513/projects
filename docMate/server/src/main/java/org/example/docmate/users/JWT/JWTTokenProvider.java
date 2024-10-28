package org.example.docmate.users.JWT;

import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JWTTokenProvider {

    private String secretKey = "Rb5xM2MK9W8kX0T2TMc2AxKwYuIAaLMFkJpVcQWW2wgWY"; // Change this to a more secure key
    private long validityInMillis = 3600000; // 1 hour

    public String createToken(String username) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("username", username);

        Date now = new Date();
        Date validity = new Date(now.getTime() + validityInMillis);

        JwtBuilder builder = Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(validity)
                .signWith(SignatureAlgorithm.HS256, secretKey);

        return builder.compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            return true;
        } catch (ExpiredJwtException e) {
            // Token expired
            System.out.println("Token expired: " + e.getMessage());
        } catch (UnsupportedJwtException e) {
            // Unsupported JWT
            System.out.println("Unsupported JWT: " + e.getMessage());
        } catch (MalformedJwtException e) {
            // Malformed token
            System.out.println("Malformed JWT: " + e.getMessage());
        } catch (SignatureException e) {
            // Invalid signature
            System.out.println("Invalid JWT signature: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            // Token string is null or empty
            System.out.println("JWT token compact of handler are invalid: " + e.getMessage());
        }
        return false;
    }


    public String getUsername(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }
}
