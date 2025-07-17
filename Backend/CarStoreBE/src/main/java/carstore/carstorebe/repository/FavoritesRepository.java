package carstore.carstorebe.repository;

import carstore.carstorebe.models.Favorites;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface FavoritesRepository extends JpaRepository<Favorites, Long>, JpaSpecificationExecutor<Favorites> {

}