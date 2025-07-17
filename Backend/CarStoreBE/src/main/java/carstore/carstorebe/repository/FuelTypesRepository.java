package carstore.carstorebe.repository;

import carstore.carstorebe.models.FuelTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface FuelTypesRepository extends JpaRepository<FuelTypes, Integer>, JpaSpecificationExecutor<FuelTypes> {

}