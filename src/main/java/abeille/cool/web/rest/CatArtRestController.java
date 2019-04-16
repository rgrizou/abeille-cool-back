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

import abeille.cool.model.CatArt;
import abeille.cool.model.Views;
import abeille.cool.repository.ICatArtRepository;

@RestController
@RequestMapping("/catArt")
@CrossOrigin("*")
public class CatArtRestController {
	@Autowired
	private ICatArtRepository catArtRepo;

	@GetMapping("")
	@JsonView(Views.ViewCatArt.class)
	public List<CatArt> list() {
		return catArtRepo.findAll();
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewCatArt.class)
	public CatArt find(@PathVariable Long id) {
		return catArtRepo.findById(id).get();
	}

	@PostMapping("")
	@JsonView(Views.ViewCatArt.class)
	public CatArt create(@RequestBody CatArt catArt) {
		catArt = catArtRepo.save(catArt);

		return catArt;
	}
	
	@PutMapping("/{id}")
	@JsonView(Views.ViewCatArt.class)
	public CatArt update(@RequestBody CatArt catArt,@PathVariable Long id) {
		catArt = catArtRepo.save(catArt);

		return catArt;
	}
	
	@DeleteMapping("/{id}")
	@JsonView(Views.ViewCatArt.class)
	public void remove(@PathVariable Long id) {
		catArtRepo.deleteById(id);
	}

}
