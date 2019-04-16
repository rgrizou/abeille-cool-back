package abeille.cool.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import abeille.cool.model.Client;

public interface IClientRepository extends JpaRepository<Client,Long>{

}
