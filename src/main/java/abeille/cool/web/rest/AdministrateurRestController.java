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

import abeille.cool.model.Administrateur;
import abeille.cool.model.Views;
import abeille.cool.repository.IAdministrateurRepository;


@RestController
@RequestMapping("/administrateur")
@CrossOrigin("*") // autoriser l'accès depuis n'importe quelle adresse
public class AdministrateurRestController {

	@Autowired
	private IAdministrateurRepository adminRepo;

	@GetMapping("")
	@JsonView(Views.ViewAdministrateur.class)
	public List<Administrateur> list() {
		return adminRepo.findAll();
	}
	
	@GetMapping("/{id}")
	@JsonView(Views.ViewAdministrateur.class)
	public Administrateur find (@PathVariable Long id) { 
		return (Administrateur) adminRepo.findById(id).get(); 
	}
	
	@PostMapping("")
	@JsonView(Views.ViewAdministrateur.class)
	public Administrateur create (@RequestBody Administrateur administrateur) {
		administrateur = adminRepo.save(administrateur); 
		
		return administrateur; 
		
	}
	
	@PutMapping("{/id}")
	@JsonView(Views.ViewAdministrateur.class)
	public Administrateur update (@RequestBody Administrateur administrateur,@PathVariable Long id) {
		administrateur = adminRepo.save(administrateur); 
		
		return administrateur; 
		
	}
	
	@DeleteMapping("/{id}")
	@JsonView(Views.ViewAdministrateur.class)
	public void remove(@PathVariable Long id) {
		adminRepo.deleteById(id);
	}

}
