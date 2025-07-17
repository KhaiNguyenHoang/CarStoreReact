package carstore.carstorebe.repository;

import carstore.carstorebe.model.RefreshTokens;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RefreshTokensRepository extends JpaRepository<RefreshTokens, Integer>, JpaSpecificationExecutor<RefreshTokens> {

}