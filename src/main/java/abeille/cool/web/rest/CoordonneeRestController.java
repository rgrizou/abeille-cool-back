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

import abeille.cool.model.Coordonnee;
import abeille.cool.model.Views;
import abeille.cool.repository.ICoordonneeRepository;

@RestController
@RequestMapping("/coordonnee")
@CrossOrigin("*")
public class CoordonneeRestController {
	@Autowired
	private ICoordonneeRepository coordonneeRepo;

	@GetMapping("")
	@JsonView(Views.ViewCoordonnee.class)
	public List<Coordonnee> list() {
		return coordonneeRepo.findAll();
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewCoordonnee.class)
	public Coordonnee find(@PathVariable Long id) {
		return coordonneeRepo.findById(id).get();
	}

	@PostMapping("")
	@JsonView(Views.ViewCoordonnee.class)
	public Coordonnee create(@RequestBody Coordonnee coordonnee) {
		coordonnee = coordonneeRepo.save(coordonnee);

		return coordonnee;
	}
	
	@PutMapping("/{id}")
	@JsonView(Views.ViewCoordonnee.class)
	public Coordonnee update(@RequestBody Coordonnee coordonnee,@PathVariable Long id) {
		coordonnee = coordonneeRepo.save(coordonnee);

		return coordonnee;
	}
	
	@DeleteMapping("/{id}")
	@JsonView(Views.ViewCoordonnee.class)
	public void remove(@PathVariable Long id) {
		coordonneeRepo.deleteById(id);
	}

}
