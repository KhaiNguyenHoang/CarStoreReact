package carstore.carstorebe.repository;

import carstore.carstorebe.model.ProductReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ProductReviewsRepository extends JpaRepository<ProductReview, Integer>, JpaSpecificationExecutor<ProductReview> {

}