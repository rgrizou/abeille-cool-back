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

import abeille.cool.model.Produit;
import abeille.cool.repository.IProduitRepository;


@RestController
@RequestMapping("/produit")
@CrossOrigin("*") 
public class ProduitRestController {
	

		@Autowired
		private IProduitRepository ProduitRepo;

		@GetMapping("")
		public List<Produit> list() {
			return ProduitRepo.findAll();
		}

		@GetMapping("/{id}")
		public Produit find(@PathVariable Long id) {
			return ProduitRepo.findById(id).get();
		}

		@PostMapping("")
		public Produit create(@RequestBody Produit produit) {
			produit = ProduitRepo.save(produit);

			return produit;
		}
		
		@PutMapping("/{id}")
		public Produit update(@RequestBody Produit produit, @PathVariable Long id) {
			produit = ProduitRepo.save(produit);

			return produit;
		}
		
		@DeleteMapping("/{id}")
		public void remove(@PathVariable Long id) {
			ProduitRepo.deleteById(id);
		}

	}

