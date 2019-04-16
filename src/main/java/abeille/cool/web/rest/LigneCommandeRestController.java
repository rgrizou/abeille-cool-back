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

import abeille.cool.model.Client;
import abeille.cool.model.LigneCommande;
import abeille.cool.model.Views;
import abeille.cool.repository.IClientRepository;
import abeille.cool.repository.ILigneCommandeRepository;

@RestController
@RequestMapping("/ligneCommande")
@CrossOrigin("*")
public class LigneCommandeRestController {
	@Autowired
	private ILigneCommandeRepository ligneCommandeRepo;

	@GetMapping("")
	@JsonView(Views.ViewLigneCommande.class)
	public List<LigneCommande> list() {
		return ligneCommandeRepo.findAll();
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewLigneCommande.class)
	public LigneCommande find(@PathVariable Long id) {
		return ligneCommandeRepo.findById(id).get();
	}

	@PostMapping("")
	@JsonView(Views.ViewLigneCommande.class)
	public LigneCommande create(@RequestBody LigneCommande ligneCommande) {
		ligneCommande = ligneCommandeRepo.save(ligneCommande);

		return ligneCommande;
	}
	
	@PutMapping("/{id}")
	@JsonView(Views.ViewLigneCommande.class)
	public LigneCommande update(@RequestBody LigneCommande ligneCommande,@PathVariable Long id) {
		ligneCommande = ligneCommandeRepo.save(ligneCommande);

		return ligneCommande;
	}
	
	@DeleteMapping("/{id}")
	@JsonView(Views.ViewLigneCommande.class)
	public void remove(@PathVariable Long id) {
		ligneCommandeRepo.deleteById(id);
	}

}
