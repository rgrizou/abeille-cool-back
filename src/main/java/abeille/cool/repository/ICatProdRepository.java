package abeille.cool.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import abeille.cool.model.CatProd;

public interface ICatProdRepository extends JpaRepository<CatProd, Long> {

}
