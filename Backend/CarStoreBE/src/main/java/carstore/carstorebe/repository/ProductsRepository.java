package carstore.carstorebe.repository;

import carstore.carstorebe.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ProductsRepository extends JpaRepository<Product, Integer>, JpaSpecificationExecutor<Product> {

}