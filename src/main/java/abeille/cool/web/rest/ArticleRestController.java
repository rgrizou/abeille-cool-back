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

import abeille.cool.model.Article;
import abeille.cool.model.TypeHydromel;
import abeille.cool.model.Views;
import abeille.cool.repository.IArticleRepository;

@RestController
@RequestMapping("/article")
@CrossOrigin("*")
public class ArticleRestController {
	@Autowired
	private IArticleRepository articleRepo;

	@GetMapping("")
	@JsonView(Views.ViewArticle.class)
	public List<Article> list() {
		return articleRepo.findAll();
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewArticle.class)
	public Article find(@PathVariable Long id) {
		return articleRepo.findById(id).get();
	}
	
	@GetMapping("/by-nom/{nom}")
	@JsonView(Views.ViewArticle.class)
	public List<Article> find(@PathVariable String nom) {
		return articleRepo.findByNom(nom);
	}
	
	@GetMapping("/by-nom")
	@JsonView(Views.ViewArticle.class)
	public List<Article> find() {
		return articleRepo.findAll();
	}
	
	@GetMapping("/by-typeHydromel/{typeHydromel}")
	@JsonView(Views.ViewArticle.class)
	public List<Article> find(@PathVariable TypeHydromel typeHydromel) {
		return articleRepo.findByTypeHydromel(typeHydromel);
	}
	
	@PostMapping("")
	@JsonView(Views.ViewArticle.class)
	public Article create(@RequestBody Article article) {
		article = articleRepo.save(article);

		return article;
	}
	
	@PutMapping("/{id}")
	@JsonView(Views.ViewArticle.class)
	public Article update(@RequestBody Article article,@PathVariable Long id) {
		article = articleRepo.save(article);

		return article;
	}
	
	@DeleteMapping("/{id}")
	@JsonView(Views.ViewArticle.class)
	public void remove(@PathVariable Long id) {
		articleRepo.deleteById(id);
	}

}
