package abeille.cool.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import abeille.cool.model.CatArt;

public interface ICatArtRepository extends JpaRepository<CatArt, Long>{

}
