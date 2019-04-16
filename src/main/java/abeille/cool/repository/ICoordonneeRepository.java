package abeille.cool.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import abeille.cool.model.Coordonnee;

public interface ICoordonneeRepository extends JpaRepository<Coordonnee,Long>{

}
