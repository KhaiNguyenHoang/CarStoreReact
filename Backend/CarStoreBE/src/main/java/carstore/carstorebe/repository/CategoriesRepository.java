package carstore.carstorebe.repository;

import carstore.carstorebe.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CategoriesRepository extends JpaRepository<Category, Integer>, JpaSpecificationExecutor<Category> {

}