package carstore.carstorebe.repository;

import carstore.carstorebe.models.SystemSettings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SystemSettingsRepository extends JpaRepository<SystemSettings, Integer>, JpaSpecificationExecutor<SystemSettings> {

}