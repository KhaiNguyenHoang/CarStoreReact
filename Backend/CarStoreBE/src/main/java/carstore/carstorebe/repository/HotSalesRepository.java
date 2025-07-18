package carstore.carstorebe.repository;

import carstore.carstorebe.model.HotSale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface HotSalesRepository extends JpaRepository<HotSale, Integer>, JpaSpecificationExecutor<HotSale> {

}