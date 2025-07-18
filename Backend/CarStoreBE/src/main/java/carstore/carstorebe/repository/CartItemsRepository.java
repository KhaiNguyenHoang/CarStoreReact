package carstore.carstorebe.repository;

import carstore.carstorebe.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CartItemsRepository extends JpaRepository<CartItem, Integer>, JpaSpecificationExecutor<CartItem> {

}