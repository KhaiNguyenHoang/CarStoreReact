package carstore.carstorebe.repository;

import carstore.carstorebe.models.OauthProviders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface OauthProvidersRepository extends JpaRepository<OauthProviders, Integer>, JpaSpecificationExecutor<OauthProviders> {

}