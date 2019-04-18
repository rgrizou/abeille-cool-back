package abeille.cool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import abeille.cool.model.Avis;

public interface IAvisRepository extends JpaRepository<Avis,Long>{
	@Query("select a from Avis a where a.article.id = :articleId  ")
	List<Avis> findAllByArticle(@Param("articleId") Long articleId);
}
