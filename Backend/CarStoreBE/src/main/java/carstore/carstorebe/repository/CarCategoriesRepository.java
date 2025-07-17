package carstore.carstorebe.repository;

import carstore.carstorebe.models.CarCategories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CarCategoriesRepository extends JpaRepository<CarCategories, Integer>, JpaSpecificationExecutor<CarCategories> {

}