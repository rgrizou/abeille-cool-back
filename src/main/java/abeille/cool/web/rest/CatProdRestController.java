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

import abeille.cool.model.CatProd;
import abeille.cool.model.Views;
import abeille.cool.repository.ICatProdRepository;


@RestController
@RequestMapping("/catProd")
@CrossOrigin("*") 
public class CatProdRestController {
	

			@Autowired
			private ICatProdRepository CatProdRepo;

			@GetMapping("")
			@JsonView(Views.ViewCatProd.class)
			public List<CatProd> list() {
				return CatProdRepo.findAll();
			}

			@GetMapping("/{id}")
			@JsonView(Views.ViewCatProd.class)
			public CatProd find(@PathVariable Long id) {
				return CatProdRepo.findById(id).get();
			}

			@PostMapping("")
			@JsonView(Views.ViewCatProd.class)
			public CatProd create(@RequestBody CatProd CatProd) {
				CatProd = CatProdRepo.save(CatProd);

				return CatProd;
			}
			
			@PutMapping("/{id}")
			@JsonView(Views.ViewCatProd.class)
			public CatProd update(@RequestBody CatProd CatProd, @PathVariable Long id) {
				CatProd = CatProdRepo.save(CatProd);

				return CatProd;
			}
			
			@DeleteMapping("/{id}")
			@JsonView(Views.ViewCatProd.class)
			public void remove(@PathVariable Long id) {
				CatProdRepo.deleteById(id);
			}

}



