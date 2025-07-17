package carstore.carstorebe.repository;

import carstore.carstorebe.model.Payments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PaymentsRepository extends JpaRepository<Payments, Integer>, JpaSpecificationExecutor<Payments> {

}