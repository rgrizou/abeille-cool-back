package abeille.cool.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import abeille.cool.model.Evenement;

public interface IEvenementRepository extends JpaRepository<Evenement,Long>{

}
