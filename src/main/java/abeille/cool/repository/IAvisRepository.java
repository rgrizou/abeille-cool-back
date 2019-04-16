package abeille.cool.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import abeille.cool.model.Avis;

public interface IAvisRepository extends JpaRepository<Avis,Long>{

}
