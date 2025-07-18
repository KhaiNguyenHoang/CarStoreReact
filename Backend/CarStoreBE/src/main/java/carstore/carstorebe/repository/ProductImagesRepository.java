package carstore.carstorebe.repository;

import carstore.carstorebe.model.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ProductImagesRepository extends JpaRepository<ProductImage, Integer>, JpaSpecificationExecutor<ProductImage> {

}