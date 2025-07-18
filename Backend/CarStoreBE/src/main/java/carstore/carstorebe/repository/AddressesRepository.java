package carstore.carstorebe.repository;

import carstore.carstorebe.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AddressesRepository extends JpaRepository<Address, Integer>, JpaSpecificationExecutor<Address> {

}