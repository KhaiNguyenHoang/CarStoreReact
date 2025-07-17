package carstore.carstorebe.repository;

import carstore.carstorebe.models.Currencies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CurrenciesRepository extends JpaRepository<Currencies, Integer>, JpaSpecificationExecutor<Currencies> {

}