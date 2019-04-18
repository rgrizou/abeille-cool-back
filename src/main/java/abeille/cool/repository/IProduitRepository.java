package abeille.cool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import abeille.cool.model.CommandeFournisseur;
import abeille.cool.model.Produit;

public interface IProduitRepository extends JpaRepository <Produit, Long> {
	
	@Query("select distinct p from Produit p join fetch p.fournisseur f where p.qte > 0 ")
	List<Produit> findAllProduitByFournisseur();

}
