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

import abeille.cool.model.Avis;
import abeille.cool.model.Views;
import abeille.cool.repository.IAvisRepository;

@RestController
@RequestMapping("/avis")
@CrossOrigin("*")
public class AvisRestController {
	@Autowired
	private IAvisRepository avisRepo;

	@GetMapping("")
	@JsonView(Views.ViewAvis.class)
	public List<Avis> list() {
		return avisRepo.findAll();
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewAvis.class)
	public Avis find(@PathVariable Long id) {
		return avisRepo.findById(id).get();
	}

	@PostMapping("")
	@JsonView(Views.ViewAvis.class)
	public Avis create(@RequestBody Avis avis) {
		avis = avisRepo.save(avis);

		return avis;
	}
	
	@PutMapping("/{id}")
	@JsonView(Views.ViewAvis.class)
	public Avis update(@RequestBody Avis avis,@PathVariable Long id) {
		avis = avisRepo.save(avis);

		return avis;
	}
	
	@DeleteMapping("/{id}")
	@JsonView(Views.ViewAvis.class)
	public void remove(@PathVariable Long id) {
		avisRepo.deleteById(id);
	}

}
