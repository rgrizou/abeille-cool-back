package abeille.cool.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import abeille.cool.model.CommandeFournisseur;

public interface ICommandeFournisseurRepository extends JpaRepository<CommandeFournisseur, Long> {

}
