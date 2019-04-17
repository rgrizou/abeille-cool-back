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
import abeille.cool.model.ProduitCatProd;
import abeille.cool.model.Views;
import abeille.cool.repository.IProduitCatProdRepository;
import abeille.cool.repository.IProduitRepository;


@RestController
@RequestMapping("/produit")
@CrossOrigin("*") 
public class ProduitRestController {
	

		@Autowired
		private IProduitRepository produitRepo;
		
		@Autowired
		private IProduitCatProdRepository produitCatProdRepo;

		@GetMapping("")
		@JsonView(Views.ViewProduit.class)
		public List<Produit> list() {
			return produitRepo.findAll();
		}

		@GetMapping("/{id}")
		@JsonView(Views.ViewProduit.class)
		public Produit find(@PathVariable Long id) {
			return produitRepo.findById(id).get();
		}

		@PostMapping("")
		@JsonView(Views.ViewProduit.class)
		public Produit create(@RequestBody Produit produit) {
			produit = produitRepo.save(produit);

			return produit;
		}
		
		@PutMapping("/{id}")
		@JsonView(Views.ViewProduit.class)
		public Produit update(@RequestBody Produit produit, @PathVariable Long id) {
			produit = produitRepo.save(produit);

			return produit;
		}
		
		@DeleteMapping("/{id}")
		@JsonView(Views.ViewProduit.class)
//		public void remove(@RequestBody ProduitCatProd produitCatProd, @PathVariable Long id) {
		public void remove(@PathVariable Long id) {
			produitCatProdRepo.deleteAll(produitCatProdRepo.findAllProduitCatProdByIdProduit(id));
			produitRepo.deleteById(id);
		}

	}

