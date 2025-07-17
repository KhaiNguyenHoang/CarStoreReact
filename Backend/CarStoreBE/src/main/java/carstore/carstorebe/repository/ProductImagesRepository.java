package carstore.carstorebe.repository;

import carstore.carstorebe.model.ProductImages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ProductImagesRepository extends JpaRepository<ProductImages, Integer>, JpaSpecificationExecutor<ProductImages> {

}