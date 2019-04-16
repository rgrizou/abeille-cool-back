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

import abeille.cool.model.ProduitCatProd;
import abeille.cool.model.Views;
import abeille.cool.repository.IProduitCatProdRepository;

@RestController
@RequestMapping("/produitCatProd")
@CrossOrigin("*")
public class ProduitCatProdRestController {
	
				@Autowired
				private IProduitCatProdRepository ProduitCatProdRepo;

				@GetMapping("")
				@JsonView(Views.ViewProduitCatProd.class)
				public List<ProduitCatProd> list() {
					return ProduitCatProdRepo.findAll();
				}

				@GetMapping("/{id}")
				@JsonView(Views.ViewProduitCatProd.class)
				public ProduitCatProd find(@PathVariable Long id) {
					return ProduitCatProdRepo.findById(id).get();
				}

				@PostMapping("")
				@JsonView(Views.ViewProduitCatProd.class)
				public ProduitCatProd create(@RequestBody ProduitCatProd ProduitCatProd) {
					ProduitCatProd = ProduitCatProdRepo.save(ProduitCatProd);

					return ProduitCatProd;
				}
				
				@PutMapping("/{id}")
				@JsonView(Views.ViewProduitCatProd.class)
				public ProduitCatProd update(@RequestBody ProduitCatProd ProduitCatProd, @PathVariable Long id) {
					ProduitCatProd = ProduitCatProdRepo.save(ProduitCatProd);

					return ProduitCatProd;
				}
				
				@DeleteMapping("/{id}")
				@JsonView(Views.ViewProduitCatProd.class)
				public void remove(@PathVariable Long id) {
					ProduitCatProdRepo.deleteById(id);
				}

	}


