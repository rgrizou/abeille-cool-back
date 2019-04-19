package abeille.cool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import abeille.cool.model.Actualite;


public interface IActualiteRepository extends JpaRepository <Actualite, Long>{
	

	@Query("select a from Actualite a ORDER BY a.date")
	List<Actualite> findByDate();
	
	@Query("select a from Actualite a where a.id != :idActualite ORDER BY a.date ")
	List<Actualite> findByHorsDate(@Param("idActualite") Long idActualite);
}

