package carstore.carstorebe.repository;

import carstore.carstorebe.model.HotSales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface HotSalesRepository extends JpaRepository<HotSales, Integer>, JpaSpecificationExecutor<HotSales> {

}