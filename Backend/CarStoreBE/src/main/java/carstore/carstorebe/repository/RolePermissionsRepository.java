package carstore.carstorebe.repository;

import carstore.carstorebe.models.RolePermissions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RolePermissionsRepository extends JpaRepository<RolePermissions, Integer>, JpaSpecificationExecutor<RolePermissions> {

}