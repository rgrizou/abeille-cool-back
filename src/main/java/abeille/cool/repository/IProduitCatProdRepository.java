package abeille.cool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import abeille.cool.model.ProduitCatProd;

public interface IProduitCatProdRepository extends JpaRepository<ProduitCatProd, Long>{

	@Query("select pc from ProduitCatProd pc join pc.produit p where p.id = :id")
	List<ProduitCatProd> findAllProduitCatProdByIdProduit(@Param("id") Long id);
	
}
