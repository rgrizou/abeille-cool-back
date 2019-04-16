package abeille.cool.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import abeille.cool.model.Actualite;

public interface IActualiteRepository extends JpaRepository <Actualite, Long>{

}
