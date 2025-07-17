package carstore.carstorebe.repository;

import carstore.carstorebe.model.CartItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CartItemsRepository extends JpaRepository<CartItems, Integer>, JpaSpecificationExecutor<CartItems> {

}