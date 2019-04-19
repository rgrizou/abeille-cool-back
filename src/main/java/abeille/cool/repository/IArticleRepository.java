package abeille.cool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import abeille.cool.model.Article;
import abeille.cool.model.TypeHydromel;



public interface IArticleRepository extends JpaRepository<Article, Long>{
	@Query("select a from Article a where lower(a.nom) LIKE lower(CONCAT('%',:nom,'%'))")
	List<Article> findByNom(@Param("nom")String nom);
	
	@Query("select a from Article a where a.typeHydromel = :typeHydromel  ")
	List<Article> findByTypeHydromel(@Param("typeHydromel") TypeHydromel typeHydromel);
	
}
