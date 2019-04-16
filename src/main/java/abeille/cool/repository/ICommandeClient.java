package abeille.cool.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import abeille.cool.model.CommandeClient;

public interface ICommandeClient extends JpaRepository<CommandeClient, Long>{

}
