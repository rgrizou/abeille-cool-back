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

import abeille.cool.model.ArticleCatArt;
import abeille.cool.model.Views;
import abeille.cool.repository.IArticleCatArtRepository;

@RestController
@RequestMapping("/articleCatArt")
@CrossOrigin("*")
public class ArticleCatArtRestController {
	@Autowired
	private IArticleCatArtRepository articleCatArtRepo;

	@GetMapping("")
	@JsonView(Views.ViewArticleCatArt.class)
	public List<ArticleCatArt> list() {
		return articleCatArtRepo.findAll();
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewArticleCatArt.class)
	public ArticleCatArt find(@PathVariable Long id) {
		return articleCatArtRepo.findById(id).get();
	}

	@PostMapping("")
	@JsonView(Views.ViewArticleCatArt.class)
	public ArticleCatArt create(@RequestBody ArticleCatArt articleCatArt) {
		articleCatArt = articleCatArtRepo.save(articleCatArt);

		return articleCatArt;
	}
	
	@PutMapping("/{id}")
	@JsonView(Views.ViewArticleCatArt.class)
	public ArticleCatArt update(@RequestBody ArticleCatArt articleCatArt,@PathVariable Long id) {
		articleCatArt = articleCatArtRepo.save(articleCatArt);

		return articleCatArt;
	}
	
	@DeleteMapping("/{id}")
	@JsonView(Views.ViewArticleCatArt.class)
	public void remove(@PathVariable Long id) {
		articleCatArtRepo.deleteById(id);
	}

}
