package carstore.carstorebe.repository;

import carstore.carstorebe.models.VerificationTokens;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface VerificationTokensRepository extends JpaRepository<VerificationTokens, Long>, JpaSpecificationExecutor<VerificationTokens> {

}