package carstore.carstorebe.repository;

import carstore.carstorebe.model.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PaymentMethodsRepository extends JpaRepository<PaymentMethod, Integer>, JpaSpecificationExecutor<PaymentMethod> {

}