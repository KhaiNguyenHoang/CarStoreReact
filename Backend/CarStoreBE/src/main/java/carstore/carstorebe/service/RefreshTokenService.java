package carstore.carstorebe.service;

import carstore.carstorebe.model.RefreshToken;
import carstore.carstorebe.model.User;
import carstore.carstorebe.repository.RefreshTokensRepository;
import carstore.carstorebe.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import carstore.carstorebe.exception.TokenRefreshException;

@Service
public class RefreshTokenService {

    @Value("${application.security.jwt.refresh-expiration}")
    private long refreshTokenDurationMs;

    private final RefreshTokensRepository refreshTokensRepository;
    private final UsersRepository usersRepository;

    public RefreshTokenService(RefreshTokensRepository refreshTokensRepository, UsersRepository usersRepository) {
        this.refreshTokensRepository = refreshTokensRepository;
        this.usersRepository = usersRepository;
    }

    public Optional<RefreshToken> findByToken(String token) {
        return refreshTokensRepository.findByToken(token);
    }

    public RefreshToken createRefreshToken(Integer userId) {
        RefreshToken refreshToken = new RefreshToken();

        refreshToken.setId(userId);
        refreshToken.setExpiryDate(new Date(System.currentTimeMillis() + refreshTokenDurationMs).toInstant());
        refreshToken.setToken(UUID.randomUUID().toString());
        refreshToken.setCreatedAt(new Date().toInstant());
        refreshToken.setIsRevoked(false);

        return refreshTokensRepository.save(refreshToken);
    }

    public RefreshToken verifyExpiration(RefreshToken token) {
        if (token.getExpiryDate().isBefore(new Date().toInstant())) {
            refreshTokensRepository.delete(token);
            throw new TokenRefreshException(token.getToken(), "Refresh token was expired. Please make a new signin request");
        }

        return token;
    }

}
