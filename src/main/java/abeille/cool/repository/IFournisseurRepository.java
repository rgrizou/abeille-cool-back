package abeille.cool.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import abeille.cool.model.Fournisseur;

public interface IFournisseurRepository extends JpaRepository<Fournisseur,Long> {

}
