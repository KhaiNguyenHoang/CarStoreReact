package carstore.carstorebe.repository;

import carstore.carstorebe.models.CarImages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CarImagesRepository extends JpaRepository<CarImages, Long>, JpaSpecificationExecutor<CarImages> {

}