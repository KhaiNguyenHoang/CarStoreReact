package carstore.carstorebe.repository;

import carstore.carstorebe.model.PaymentMethods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PaymentMethodsRepository extends JpaRepository<PaymentMethods, Integer>, JpaSpecificationExecutor<PaymentMethods> {

}