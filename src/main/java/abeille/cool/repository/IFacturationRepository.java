package abeille.cool.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import abeille.cool.model.Facturation;

public interface IFacturationRepository extends JpaRepository<Facturation,Long>{

}
