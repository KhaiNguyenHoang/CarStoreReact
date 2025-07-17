package carstore.carstorebe.repository;

import carstore.carstorebe.models.CarBrands;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CarBrandsRepository extends JpaRepository<CarBrands, Integer>, JpaSpecificationExecutor<CarBrands> {

}