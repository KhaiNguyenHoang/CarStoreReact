package carstore.carstorebe.repository;

import carstore.carstorebe.model.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Integer>, JpaSpecificationExecutor<OrderDetails> {

}