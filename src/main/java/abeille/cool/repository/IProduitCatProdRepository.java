package abeille.cool.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import abeille.cool.model.ProduitCatProd;

public interface IProduitCatProdRepository extends JpaRepository<ProduitCatProd, Long>{

}
