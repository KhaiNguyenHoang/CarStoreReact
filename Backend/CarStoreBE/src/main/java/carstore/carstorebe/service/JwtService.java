package carstore.carstorebe.service;

import carstore.carstorebe.models.RefreshTokens;
import carstore.carstorebe.models.Users;
import carstore.carstorebe.repository.RefreshTokensRepository;
import carstore.carstorebe.repository.UsersRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class JwtService {

    @Value("${application.security.jwt.secret-key}")
    private String secretKey;
    @Value("${application.security.jwt.expiration}")
    private long jwtExpiration;
    @Value("${application.security.jwt.refresh-expiration}")
    private long refreshExpiration;

    private final RefreshTokensRepository refreshTokensRepository;
    private final UsersRepository usersRepository;

    public JwtService(RefreshTokensRepository refreshTokensRepository, UsersRepository usersRepository) {
        this.refreshTokensRepository = refreshTokensRepository;
        this.usersRepository = usersRepository;
    }

    public String generateToken(String userName) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, userName, jwtExpiration);
    }

    public String generateRefreshToken(String userName, Long userId) {
        String refreshToken = UUID.randomUUID().toString();
        RefreshTokens refreshTokenEntity = RefreshTokens.builder()
                .userId(userId)
                .tokenHash(refreshToken)
                .expiresAt(new Date(System.currentTimeMillis() + refreshExpiration).toString())
                .revoked(false)
                .build();
        refreshTokensRepository.save(refreshTokenEntity);
        return refreshToken;
    }

    private String createToken(Map<String, Object> claims, String userName, long expiration) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userName)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(getSignKey(), SignatureAlgorithm.HS256).compact();
    }

    private Key getSignKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String extractUserName(String token) {
        return Jwts.parser()
                .setSigningKey(getSignKey())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        final String userName = extractUserName(token);
        return (userName.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    public Boolean validateRefreshToken(String refreshToken) {
        return refreshTokensRepository.findByTokenHashAndRevokedFalse(refreshToken)
                .map(token -> new Date().before(new Date(token.getExpiresAt())))
                .orElse(false);
    }

    public void revokeRefreshToken(String refreshToken) {
        refreshTokensRepository.findByTokenHashAndRevokedFalse(refreshToken)
                .ifPresent(token -> {
                    token.setRevoked(true);
                    refreshTokensRepository.save(token);
                });
    }

    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return Jwts.parser()
                .setSigningKey(getSignKey())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getExpiration();
    }
}
