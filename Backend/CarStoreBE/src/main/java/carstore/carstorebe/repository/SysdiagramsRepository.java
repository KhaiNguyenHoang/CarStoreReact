package carstore.carstorebe.repository;

import carstore.carstorebe.models.Sysdiagrams;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SysdiagramsRepository extends JpaRepository<Sysdiagrams, Integer>, JpaSpecificationExecutor<Sysdiagrams> {

}