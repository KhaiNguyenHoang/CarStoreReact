package carstore.carstorebe.repository;

import carstore.carstorebe.model.EmailVerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface EmailVerificationTokensRepository extends JpaRepository<EmailVerificationToken, Integer>, JpaSpecificationExecutor<EmailVerificationToken> {

}