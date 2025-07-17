package carstore.carstorebe.repository;

import carstore.carstorebe.models.UserAddresses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserAddressesRepository extends JpaRepository<UserAddresses, Long>, JpaSpecificationExecutor<UserAddresses> {

}