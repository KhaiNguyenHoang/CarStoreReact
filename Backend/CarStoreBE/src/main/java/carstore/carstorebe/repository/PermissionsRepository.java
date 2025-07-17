package carstore.carstorebe.repository;

import carstore.carstorebe.models.Permissions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PermissionsRepository extends JpaRepository<Permissions, Integer>, JpaSpecificationExecutor<Permissions> {

}