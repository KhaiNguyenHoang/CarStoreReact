package carstore.carstorebe.repository;

import carstore.carstorebe.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PaymentsRepository extends JpaRepository<Payment, Integer>, JpaSpecificationExecutor<Payment> {

}