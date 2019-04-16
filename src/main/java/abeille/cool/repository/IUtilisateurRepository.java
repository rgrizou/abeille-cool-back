package abeille.cool.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import abeille.cool.model.Utilisateur;

public interface IUtilisateurRepository extends JpaRepository<Utilisateur, Long> {

}
