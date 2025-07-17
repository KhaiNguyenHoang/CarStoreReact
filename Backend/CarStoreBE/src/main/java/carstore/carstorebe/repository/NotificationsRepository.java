package carstore.carstorebe.repository;

import carstore.carstorebe.models.Notifications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface NotificationsRepository extends JpaRepository<Notifications, Long>, JpaSpecificationExecutor<Notifications> {

}