package abeille.cool.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import abeille.cool.model.Produit;

public interface IProduitRepository extends JpaRepository <Produit, Long> {

	
	
}
