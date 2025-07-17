package carstore.carstorebe.repository;

import carstore.carstorebe.models.Statuses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface StatusesRepository extends JpaRepository<Statuses, Integer>, JpaSpecificationExecutor<Statuses> {

}