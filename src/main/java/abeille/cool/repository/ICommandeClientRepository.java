package abeille.cool.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import abeille.cool.model.CommandeClient;

public interface ICommandeClientRepository extends JpaRepository<CommandeClient, Long>{

}
