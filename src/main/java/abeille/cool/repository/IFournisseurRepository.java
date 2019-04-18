package abeille.cool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import abeille.cool.model.CommandeFournisseur;
import abeille.cool.model.Fournisseur;


public interface IFournisseurRepository extends JpaRepository<Fournisseur,Long> {
	
	

}
