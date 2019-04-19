package abeille.cool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import abeille.cool.model.CommandeClient;

public interface ICommandeClientRepository extends JpaRepository<CommandeClient, Long>{
	@Query("select f from CommandeClient f where f.facturation.id = :idFacturation")
	CommandeClient findCommandeByFacture(@Param("idFacturation") Long idFacturation);
	
	@Query("select c from CommandeClient c where c.client.id =:clientId and c.statut='Panier'")
	List<CommandeClient> findPanierByClientId(@Param("clientId") Long clientID);
}
