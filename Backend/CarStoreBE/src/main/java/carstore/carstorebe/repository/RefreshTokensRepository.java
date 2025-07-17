package carstore.carstorebe.repository;

import carstore.carstorebe.models.RefreshTokens;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface RefreshTokensRepository extends JpaRepository<RefreshTokens, Long>, JpaSpecificationExecutor<RefreshTokens> {
    Optional<RefreshTokens> findByTokenHashAndRevokedFalse(String tokenHash);
}