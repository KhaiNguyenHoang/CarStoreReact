package carstore.carstorebe.repository;

import carstore.carstorebe.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ProductsRepository extends JpaRepository<Products, Integer>, JpaSpecificationExecutor<Products> {

}