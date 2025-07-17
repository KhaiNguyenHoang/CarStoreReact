package carstore.carstorebe.repository;

import carstore.carstorebe.models.Cars;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CarsRepository extends JpaRepository<Cars, Long>, JpaSpecificationExecutor<Cars> {

}