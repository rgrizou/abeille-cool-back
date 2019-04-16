package abeille.cool.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import abeille.cool.model.Article;

public interface IArticleRepository extends JpaRepository<Article, Long>{

}
