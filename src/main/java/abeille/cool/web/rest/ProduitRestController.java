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

import abeille.cool.model.Produit;
import abeille.cool.model.Views;
import abeille.cool.repository.IProduitRepository;


@RestController
@RequestMapping("/produit")
@CrossOrigin("*") 
public class ProduitRestController {
	

		@Autowired
		private IProduitRepository ProduitRepo;

		@GetMapping("")
		@JsonView(Views.ViewProduit.class)
		public List<Produit> list() {
			return ProduitRepo.findAll();
		}
		
		@GetMapping("/by-fournisseur")
		@JsonView(Views.ViewProduitWithFournisseur.class)
		public List<Produit> listByFournisseur() {
			return ProduitRepo.findAllProduitByFournisseur();
		}

		@GetMapping("/{id}")
		@JsonView(Views.ViewProduit.class)
		public Produit find(@PathVariable Long id) {
			return ProduitRepo.findById(id).get();
		}

		@PostMapping("")
		@JsonView(Views.ViewProduit.class)
		public Produit create(@RequestBody Produit produit) {
			produit = ProduitRepo.save(produit);

			return produit;
		}
		
		@PutMapping("/{id}")
		@JsonView(Views.ViewProduit.class)
		public Produit update(@RequestBody Produit produit, @PathVariable Long id) {
			produit = ProduitRepo.save(produit);

			return produit;
		}
		
		@DeleteMapping("/{id}")
		@JsonView(Views.ViewProduit.class)
		public void remove(@PathVariable Long id) {
			ProduitRepo.deleteById(id);
		}

	}

