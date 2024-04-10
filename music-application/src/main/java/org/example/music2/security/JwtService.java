//package org.example.music2.security;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import io.jsonwebtoken.security.Keys;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Service;
//
//import javax.crypto.Mac;
//import javax.crypto.SecretKey;
//import javax.crypto.spec.SecretKeySpec;
//import java.nio.charset.StandardCharsets;
//import java.util.Base64;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.function.Function;
//
//@Service
//public class JwtService {
//
//    @Value("${JWT_SECRET_KEY:default_secret_key}")
//    private String secretKey;
//
//    @Value("${JWT_EXPIRATION_DURATION:86400000}") // Default to 24 hours in milliseconds
//    private long tokenExpirationDuration;
//
//    public String extractUserName(String token) {
//        return extractClaim(token, Claims::getSubject);
//    }
//
//    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
//        final Claims claims = extractAllClaims(token);
//        return claimsResolver.apply(claims);
//    }
//
//    public String generateToken(UserDetails userDetails) {
//        return generateToken(new HashMap<>(), userDetails);
//    }
//
//    public String generateToken(Map<String, Object> extractClaims, UserDetails userDetails) {
//        return Jwts.builder()
//                .setClaims(extractClaims)
//                .setSubject(userDetails.getUsername())
//
//                .setIssuedAt(new Date(System.currentTimeMillis()))
//                .setExpiration(new Date(System.currentTimeMillis() + tokenExpirationDuration))
//                .signWith(getSigningKey())
//                .compact();
//    }
//
//    public boolean isTokenValid(String token, UserDetails userDetails) {
//        final String username = extractUserName(token);
//        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
//    }
//
//    private boolean isTokenExpired(String token) {
//        return extractExpiration(token).before(new Date());
//    }
//
//    private Date extractExpiration(String token) {
//        return extractClaim(token, Claims::getExpiration);
//    }
//
//    private Claims extractAllClaims(String token) {
//        return Jwts.parserBuilder()
//                .setSigningKey(getSigningKey())
//                .build()
//                .parseClaimsJws(token)
//                .getBody();
//    }
//
//    private SecretKey getSigningKey() {
//        return Keys.secretKeyFor(SignatureAlgorithm.HS256);
//    }
//
//
//    public String extractSignature(String jwt) {
//        String[] jwtParts = jwt.split("\\.");
//        return jwtParts.length == 3 ? jwtParts[2] : null;
//    }
//
//    public String computeSignature(String jwt) {
//        String[] jwtParts = jwt.split("\\.");
//        if (jwtParts.length != 3) {
//            return null; // Invalid JWT format
//        }
//
//        String headerAndPayload = jwtParts[0] + "." + jwtParts[1];
//        String algorithm = extractAlgorithm(jwt);
//        String secretKey = this.secretKey; // Use the secret key from your configuration
//
//        try {
//            Mac mac = Mac.getInstance("Hmac" + algorithm.toUpperCase());
//            mac.init(new SecretKeySpec(secretKey.getBytes(StandardCharsets.UTF_8), algorithm));
//            byte[] signatureBytes = mac.doFinal(headerAndPayload.getBytes(StandardCharsets.UTF_8));
//            return Base64.getUrlEncoder().withoutPadding().encodeToString(signatureBytes);
//        } catch (Exception e) {
//            e.printStackTrace(); // Handle the exception appropriately
//            return null;
//        }
//    }
//
//    private String extractAlgorithm(String jwt) {
//        String[] jwtParts = jwt.split("\\.");
//        if (jwtParts.length >= 2) {
//            byte[] decodedBytes = Base64.getUrlDecoder().decode(jwtParts[0]);
//            String headerJson = new String(decodedBytes, StandardCharsets.UTF_8);
//            // Extract algorithm from header JSON
//            // You can use a JSON library or parse it manually
//        }
//        return null;
//    }
//}
