package abeille.cool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import abeille.cool.model.Client;
import abeille.cool.model.ClientEvenement;


public interface IClientEvenementRepository extends JpaRepository<ClientEvenement,Long> {
	@Query("select ce.client from ClientEvenement ce where ce.event.id = :eventId")
	List<Client> findAllClientByEvent(@Param("eventId") Long eventId);
	
	@Query("select ce.event from ClientEvenement ce where ce.client.id = :clientId")
	List<Client> findAllEventByClient(@Param("clientId") Long clientId);
}