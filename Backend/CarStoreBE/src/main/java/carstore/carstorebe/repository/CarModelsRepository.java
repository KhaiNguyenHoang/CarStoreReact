package carstore.carstorebe.repository;

import carstore.carstorebe.models.CarModels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CarModelsRepository extends JpaRepository<CarModels, Integer>, JpaSpecificationExecutor<CarModels> {

}