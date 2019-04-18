package abeille.cool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import abeille.cool.model.CommandeClient;
import abeille.cool.model.Coordonnee;

public interface ICommandeClientRepository extends JpaRepository<CommandeClient, Long>{
	@Query("select f from CommandeClient f where f.facturation.id = :idFacturation")
	CommandeClient findCommandeByFacture(@Param("idFacturation") Long idFacturation);
}
