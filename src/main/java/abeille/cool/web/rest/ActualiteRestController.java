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

import abeille.cool.model.Actualite;
import abeille.cool.model.Views;
import abeille.cool.repository.IActualiteRepository;

@RestController
@RequestMapping("/actualite") // map l'url du back, accessible depuis le http.service.ts du component côté front.
@CrossOrigin("*") // autoriser l'accès depuis n'importe quelle adresse
public class ActualiteRestController {

	@Autowired
	private IActualiteRepository actuRepo;

	@GetMapping("")
	@JsonView(Views.ViewActualite.class)
	public List<Actualite> list() {
		return actuRepo.findAll();
	}
	
	@GetMapping("/{id}")// map l'url du back, accessible depuis le http.service.ts du component côté front.
	@JsonView(Views.ViewActualite.class)
	public Actualite find (@PathVariable Long id) { 
		return (Actualite) actuRepo.findById(id).get(); 
	}
	
	@PostMapping("")
	@JsonView(Views.ViewActualite.class)
	public Actualite create (@RequestBody Actualite actualite) {
		actualite = actuRepo.save(actualite); 
		
		return actualite; 
		
	}
	
	@PutMapping("{/id}")// map l'url du back, accessible depuis le http.service.ts du component côté front.
	@JsonView(Views.ViewActualite.class)
	public Actualite update (@RequestBody Actualite actualite, @PathVariable Long id) {
		actualite = actuRepo.save(actualite); 
		
		return actualite; 
		
	}
	
	@DeleteMapping("/{id}") // map l'url du back, accessible depuis le http.service.ts du component côté front.
	@JsonView(Views.ViewActualite.class)
	public void remove(@PathVariable Long id) {
		actuRepo.deleteById(id);
	}

	@GetMapping("/by-date")// map l'url du back, accessible depuis le http.service.ts du component côté front.
	@JsonView(Views.ViewActualite.class)
	public Actualite findDate() {
		List<Actualite> actus = actuRepo.findByDate();
		return actus.get(actus.size()-1);
	}

	@GetMapping("/by-hors-date")
	@JsonView(Views.ViewActualite.class)
	public List<Actualite> findHorsDate() {
		List<Actualite> actus= actuRepo.findByHorsDate(findDate().getId());
		for(int i = 0; i < actus.size() / 2; i++)
		 {
		     Actualite  temp = actus.get(i);
		     actus.set(i, actus.get(actus.size()-i-1));
		     actus.set(actus.size()-i-1, temp);
		 }
		return actus;
		
	}
}
