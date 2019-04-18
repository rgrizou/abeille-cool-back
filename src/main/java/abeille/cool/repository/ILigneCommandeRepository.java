package abeille.cool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import abeille.cool.model.LigneCommande;

public interface ILigneCommandeRepository extends JpaRepository<LigneCommande,Long>{

	@Query("select lc from LigneCommande lc where lc.commandeClient.id = :commandeClientId")
	List<LigneCommande> findByCommandeClientId(@Param("commandeClientId") Long commandeClientId);
}
