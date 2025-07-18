package carstore.carstorebe.repository;

import carstore.carstorebe.model.Voucher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface VouchersRepository extends JpaRepository<Voucher, Integer>, JpaSpecificationExecutor<Voucher> {

}