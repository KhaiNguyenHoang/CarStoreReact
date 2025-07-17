package carstore.carstorebe.repository;

import carstore.carstorebe.model.ProductReviews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ProductReviewsRepository extends JpaRepository<ProductReviews, Integer>, JpaSpecificationExecutor<ProductReviews> {

}