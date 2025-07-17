package carstore.carstorebe.repository;

import carstore.carstorebe.models.OauthConnections;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface OauthConnectionsRepository extends JpaRepository<OauthConnections, Long>, JpaSpecificationExecutor<OauthConnections> {

}