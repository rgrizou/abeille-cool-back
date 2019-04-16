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


import abeille.cool.model.Actualite;
import abeille.cool.repository.IActualiteRepository;

@RestController
@RequestMapping("/actualite")
@CrossOrigin("*") // autoriser l'accès depuis n'importe quelle adresse
public class ActualiteRestController {

	@Autowired
	private IActualiteRepository actuRepo;

	@GetMapping("")
	public List<Actualite> list() {
		return actuRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Actualite find (@PathVariable Long id) { 
		return (Actualite) actuRepo.findById(id).get(); 
	}
	
	@PostMapping("")
	public Actualite create (@RequestBody Actualite actualite) {
		actualite = actuRepo.save(actualite); 
		
		return actualite; 
		
	}
	
	@PutMapping("{/id}")
	public Actualite update (@RequestBody Actualite actualite, @PathVariable Long id) {
		actualite = actuRepo.save(actualite); 
		
		return actualite; 
		
	}
	
	@DeleteMapping("/{id}")
	public void remove(@PathVariable Long id) {
		actuRepo.deleteById(id);
	}

}
