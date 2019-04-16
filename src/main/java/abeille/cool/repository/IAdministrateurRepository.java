package abeille.cool.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import abeille.cool.model.Administrateur;

public interface IAdministrateurRepository extends JpaRepository <Administrateur, Long>{

}
