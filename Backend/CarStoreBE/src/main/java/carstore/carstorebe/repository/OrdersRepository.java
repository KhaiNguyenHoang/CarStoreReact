package carstore.carstorebe.repository;

import carstore.carstorebe.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface OrdersRepository extends JpaRepository<Order, Integer>, JpaSpecificationExecutor<Order> {

}