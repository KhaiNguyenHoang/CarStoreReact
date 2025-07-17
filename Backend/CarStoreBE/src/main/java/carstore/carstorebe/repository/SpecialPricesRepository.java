package carstore.carstorebe.repository;

import carstore.carstorebe.model.SpecialPrices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SpecialPricesRepository extends JpaRepository<SpecialPrices, Integer>, JpaSpecificationExecutor<SpecialPrices> {

}