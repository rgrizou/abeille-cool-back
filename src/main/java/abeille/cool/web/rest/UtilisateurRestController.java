package abeille.cool.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import abeille.cool.model.Utilisateur;
import abeille.cool.model.Views;
import abeille.cool.repository.IUtilisateurRepository;

@RestController
@RequestMapping("/utilisateur")
@CrossOrigin("*")
public class UtilisateurRestController {

	@Autowired
	private IUtilisateurRepository utilisateurRepo;

	@GetMapping("")
	@JsonView(Views.ViewUtilisateur.class)
	public List<Utilisateur> list() {
		return utilisateurRepo.findAll();
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewUtilisateur.class)
	public Utilisateur find(@PathVariable Long id) {
		return utilisateurRepo.findById(id).get();
	}

	@PostMapping("")
	@JsonView(Views.ViewUtilisateur.class)
	public Utilisateur create(@RequestBody Utilisateur utilisateur) {
		utilisateur = utilisateurRepo.save(utilisateur);
		return utilisateur;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewUtilisateur.class)
	public Utilisateur update(@RequestBody Utilisateur utilisateur, @PathVariable Long id) {
		utilisateur = utilisateurRepo.save(utilisateur);
		return utilisateur;
	}

	@DeleteMapping("/{id}")
	@JsonView(Views.ViewUtilisateur.class)
	public void remove(@PathVariable Long id) {
		utilisateurRepo.deleteById(id);
	}

}