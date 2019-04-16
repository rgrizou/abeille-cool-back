package abeille.cool.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import abeille.cool.model.LigneCommande;

public interface ILigneCommandeRepository extends JpaRepository<LigneCommande,Long>{

}
