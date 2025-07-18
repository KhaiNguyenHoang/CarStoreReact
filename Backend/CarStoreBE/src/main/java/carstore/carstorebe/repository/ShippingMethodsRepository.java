package carstore.carstorebe.repository;

import carstore.carstorebe.model.ShippingMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ShippingMethodsRepository extends JpaRepository<ShippingMethod, Integer>, JpaSpecificationExecutor<ShippingMethod> {

}