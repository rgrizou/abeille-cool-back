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

import abeille.cool.model.Evenement;
import abeille.cool.model.Views;
import abeille.cool.repository.IEvenementRepository;

@RestController
@RequestMapping("/evenement")
@CrossOrigin("*") // autoriser l'accès depuis n'importe quelle adresse
public class EvenementRestController {
	
	@Autowired
	private IEvenementRepository evenementRepo;

	@GetMapping("")
	@JsonView(Views.ViewEvenement.class)
	public List<Evenement> list() {
		return evenementRepo.findAll();
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewEvenement.class)
	public Evenement find(@PathVariable Long id) {
		return evenementRepo.findById(id).get();
	}

	@PostMapping("")
	@JsonView(Views.ViewEvenement.class)
	public Evenement create(@RequestBody Evenement evenement) {
		evenement = evenementRepo.save(evenement);

		return evenement;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewEvenement.class)
	public Evenement update(@RequestBody Evenement evenement, @PathVariable Long id) {
		evenement = evenementRepo.save(evenement);

		return evenement;
	}

	@DeleteMapping("/{id}")
	@JsonView(Views.ViewEvenement.class)
	public void remove(@PathVariable Long id) {
		evenementRepo.deleteById(id);
	}

}
