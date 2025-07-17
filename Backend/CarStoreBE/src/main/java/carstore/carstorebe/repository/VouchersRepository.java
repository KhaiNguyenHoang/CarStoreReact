package carstore.carstorebe.repository;

import carstore.carstorebe.model.Vouchers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface VouchersRepository extends JpaRepository<Vouchers, Integer>, JpaSpecificationExecutor<Vouchers> {

}