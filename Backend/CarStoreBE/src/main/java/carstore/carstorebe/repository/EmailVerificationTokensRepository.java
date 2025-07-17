package carstore.carstorebe.repository;

import carstore.carstorebe.model.EmailVerificationTokens;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface EmailVerificationTokensRepository extends JpaRepository<EmailVerificationTokens, Integer>, JpaSpecificationExecutor<EmailVerificationTokens> {

}