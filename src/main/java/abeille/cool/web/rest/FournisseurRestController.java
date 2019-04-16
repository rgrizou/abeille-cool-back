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

import abeille.cool.model.Fournisseur;
import abeille.cool.model.Views;
import abeille.cool.repository.IFournisseurRepository;

@RestController
@RequestMapping("/fournisseur")
@CrossOrigin("*")
public class FournisseurRestController {

	@Autowired
	private IFournisseurRepository fournisseurRepo;
	
	@GetMapping("")
	@JsonView(Views.ViewFournisseur.class)
	public List<Fournisseur> list() {
		return fournisseurRepo.findAll();
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewFournisseur.class)
	public Fournisseur find(@PathVariable Long id) {
		return fournisseurRepo.findById(id).get();
	}

	@PostMapping("")
	@JsonView(Views.ViewFournisseur.class)
	public Fournisseur create(@RequestBody Fournisseur fournisseur) {
		fournisseur = fournisseurRepo.save(fournisseur);

		return fournisseur;
	}
	
	@PutMapping("/{id}")
	@JsonView(Views.ViewFournisseur.class)
	public Fournisseur update(@RequestBody Fournisseur fournisseur,@PathVariable Long id) {
		fournisseur = fournisseurRepo.save(fournisseur);

		return fournisseur;
	}
	
	@DeleteMapping("/{id}")
	@JsonView(Views.ViewFournisseur.class)
	public void remove(@PathVariable Long id) {
		fournisseurRepo.deleteById(id);
	}
	
}
