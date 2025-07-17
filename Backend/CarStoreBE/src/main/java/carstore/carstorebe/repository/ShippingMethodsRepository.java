package carstore.carstorebe.repository;

import carstore.carstorebe.model.ShippingMethods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ShippingMethodsRepository extends JpaRepository<ShippingMethods, Integer>, JpaSpecificationExecutor<ShippingMethods> {

}