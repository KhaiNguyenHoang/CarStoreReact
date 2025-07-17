package carstore.carstorebe.repository;

import carstore.carstorebe.model.Addresses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AddressesRepository extends JpaRepository<Addresses, Integer>, JpaSpecificationExecutor<Addresses> {

}