package com.example.login.security.jwt;

import com.example.login.security.userprincal.MyUserDetails;
import io.jsonwebtoken.*;

import java.util.Date;

public class JwtTokenProvider {
    private final String JWT_SECRET = "C0623G1";
    private final long JWT_EXPIRATION = 86400;
    // Tạo ra jwt từ thông tin user
    public String generateToken(MyUserDetails userDetails) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + JWT_EXPIRATION);
        // Tạo chuỗi json web token từ id của user.
        return Jwts.builder()
                .setSubject(Long.toString(userDetails.getUser().getId()))
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, JWT_SECRET)
                .compact();
    }

    // Lấy thông tin user từ jwt
    public Long getUserIdFromJWT(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(JWT_SECRET)
                .parseClaimsJws(token)
                .getBody();

        return Long.parseLong(claims.getSubject());
    }

    public boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(authToken);
            return true;
        } catch (MalformedJwtException ex) {
            System.out.println("JWT Token không hợp lệ");
        } catch (ExpiredJwtException ex) {
            System.out.println("JWT Token đã hết hạn");
        } catch (UnsupportedJwtException ex) {
            System.out.println("JWT Token không được hỗ trợ");
        } catch (IllegalArgumentException ex) {
            System.out.println("JWT Token trống.");
        }
        return false;
    }
}
