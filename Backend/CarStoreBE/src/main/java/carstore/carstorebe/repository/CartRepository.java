package carstore.carstorebe.repository;

import carstore.carstorebe.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CartRepository extends JpaRepository<Cart, Integer>, JpaSpecificationExecutor<Cart> {

}