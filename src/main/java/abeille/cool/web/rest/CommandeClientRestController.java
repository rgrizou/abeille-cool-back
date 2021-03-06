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

import abeille.cool.model.CommandeClient;
import abeille.cool.model.Views;
import abeille.cool.repository.ICommandeClientRepository;

@RestController
@RequestMapping("/commandeClient")
@CrossOrigin("*") // autoriser l'accès depuis n'importe quelle adresse
public class CommandeClientRestController {
	@Autowired
	private ICommandeClientRepository commandeClientRepo;

	@GetMapping("")
	@JsonView(Views.ViewCommandeClient.class)
	public List<CommandeClient> list() {
		return commandeClientRepo.findAll();
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewCommandeClient.class)
	public CommandeClient find(@PathVariable Long id) {
		return commandeClientRepo.findById(id).get();
	}
	
	@GetMapping("/by-facture/{idFacture}")
	@JsonView(Views.ViewCoordonnee.class)
	public CommandeClient findByFacture(@PathVariable Long idFacture) {
		return commandeClientRepo.findCommandeByFacture(idFacture);
	}
	
	@PostMapping("")
	@JsonView(Views.ViewCommandeClient.class)
	public CommandeClient create(@RequestBody CommandeClient commandeClient) {
		commandeClient = commandeClientRepo.save(commandeClient);

		return commandeClient;
	}
	
	@PutMapping("/{id}")
	@JsonView(Views.ViewCommandeClient.class)
	public CommandeClient update(@RequestBody CommandeClient commandeClient, @PathVariable Long id) {
		commandeClient = commandeClientRepo.save(commandeClient);

		return commandeClient;
	}
	@DeleteMapping("/{id}")
	@JsonView(Views.ViewCommandeClient.class)
	public void remove(@PathVariable Long id) {
		commandeClientRepo.deleteById(id);
	}
	
	@GetMapping("/by-client/{clientId}")
	@JsonView(Views.ViewCommandeClient.class)
	public List<CommandeClient> findPanierByClientId(@PathVariable Long clientId){
		return commandeClientRepo.findPanierByClientId(clientId);
	}
}
