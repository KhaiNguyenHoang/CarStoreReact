package carstore.carstorebe.repository;

import carstore.carstorebe.model.SpecialPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SpecialPricesRepository extends JpaRepository<SpecialPrice, Integer>, JpaSpecificationExecutor<SpecialPrice> {

}