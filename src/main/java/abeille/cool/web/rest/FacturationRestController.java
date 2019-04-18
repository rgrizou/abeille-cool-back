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

import abeille.cool.model.Facturation;
import abeille.cool.model.Views;
import abeille.cool.repository.IFacturationRepository;

@RestController
@RequestMapping("/facturation")
@CrossOrigin("*") // autoriser l'accès depuis n'importe quelle adresse
public class FacturationRestController {
	
	@Autowired
	private IFacturationRepository facturationRepo;

	@GetMapping("")
	@JsonView(Views.ViewFacturation.class)
	public List<Facturation> list() {
		return facturationRepo.findAll();
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewFacturation.class)
	public Facturation find(@PathVariable Long id) {
		return facturationRepo.findById(id).get();
	}

	@PostMapping("")
	@JsonView(Views.ViewFacturation.class)
	public Facturation create(@RequestBody Facturation facturation) {
		facturation = facturationRepo.save(facturation);

		return facturation;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewFacturation.class)
	public Facturation update(@RequestBody Facturation facturation, @PathVariable Long id) {
		facturation = facturationRepo.save(facturation);

		return facturation;
	}

	@DeleteMapping("/{id}")
	@JsonView(Views.ViewFacturation.class)
	public void remove(@PathVariable Long id) {
		facturationRepo.deleteById(id);
	}

}
