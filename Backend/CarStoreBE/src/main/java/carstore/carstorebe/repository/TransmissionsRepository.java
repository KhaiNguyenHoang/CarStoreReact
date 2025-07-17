package carstore.carstorebe.repository;

import carstore.carstorebe.models.Transmissions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TransmissionsRepository extends JpaRepository<Transmissions, Integer>, JpaSpecificationExecutor<Transmissions> {

}