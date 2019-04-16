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

import abeille.cool.model.CommandeFournisseur;
import abeille.cool.model.Views;
import abeille.cool.repository.ICommandeFournisseurRepository;

@RestController
@RequestMapping("/commandeFournisseur")
@CrossOrigin("*")
public class CommandeFournisseurRestController {

	@Autowired
	private ICommandeFournisseurRepository commandeFournisseurRepo;

	@GetMapping("")
	@JsonView(Views.ViewCommon.class)
	public List<CommandeFournisseur> list() {
		return commandeFournisseurRepo.findAll();
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewCommandeFournisseur.class)
	public CommandeFournisseur find(@PathVariable Long id) {
		return commandeFournisseurRepo.findById(id).get();
	}

	@PostMapping("")
	@JsonView(Views.ViewCommandeFournisseur.class)
	public CommandeFournisseur create(@RequestBody CommandeFournisseur commandeFournisseur) {
		commandeFournisseur = commandeFournisseurRepo.save(commandeFournisseur);
		return commandeFournisseur;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewCommandeFournisseur.class)
	public CommandeFournisseur update(@RequestBody CommandeFournisseur commandeFournisseur, @PathVariable Long id) {
		commandeFournisseur = commandeFournisseurRepo.save(commandeFournisseur);
		return commandeFournisseur;
	}

	@DeleteMapping("/{id}")
	@JsonView(Views.ViewCommandeFournisseur.class)
	public void remove(@PathVariable Long id) {
		commandeFournisseurRepo.deleteById(id);
	}

}
