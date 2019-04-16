package abeille.cool.web.rest;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import abeille.cool.model.Evenement;
import abeille.cool.repository.IEvenementRepository;

@RestController
@RequestMapping("/evenement")
@CrossOrigin("*") // autoriser l'accès depuis n'importe quelle adresse
public class EvenementRestController {

	private IEvenementRepository evenementRepo;

	@GetMapping("")
	public List<Evenement> list() {
		return evenementRepo.findAll();
	}

	@GetMapping("/{id}")
	public Evenement find(@PathVariable Long id) {
		return evenementRepo.findById(id).get();
	}

	@PostMapping("")
	public Evenement create(@RequestBody Evenement evenement) {
		evenement = evenementRepo.save(evenement);

		return evenement;
	}

	@PutMapping("/{id}")
	public Evenement update(@RequestBody Evenement evenement, @PathVariable Long id) {
		evenement = evenementRepo.save(evenement);

		return evenement;
	}

	@DeleteMapping("/{id}")
	public void remove(@PathVariable Long id) {
		evenementRepo.deleteById(id);
	}

}
