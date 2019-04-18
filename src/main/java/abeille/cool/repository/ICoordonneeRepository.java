package abeille.cool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import abeille.cool.model.Coordonnee;

public interface ICoordonneeRepository extends JpaRepository<Coordonnee,Long>{
	@Query("select c from Coordonnee c where c.client.id = :idClient")
	List<Coordonnee> findAllCoordonneeByClient(@Param("idClient") Long idClient);
}
