package carstore.carstorebe.repository;

import carstore.carstorebe.models.RefreshTokens;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RefreshTokensRepository extends JpaRepository<RefreshTokens, Long>, JpaSpecificationExecutor<RefreshTokens> {

}