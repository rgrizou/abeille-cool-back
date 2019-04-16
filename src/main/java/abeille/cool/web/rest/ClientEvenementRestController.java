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

import abeille.cool.repository.IClientEvenementRepository;
import abeille.cool.model.ClientEvenement;
import abeille.cool.model.Views;

@RestController
@RequestMapping("/clientEvenement")
@CrossOrigin("*")
public class ClientEvenementRestController {

	@Autowired
	private IClientEvenementRepository clientEvenementRepo;
	
	@GetMapping("")
	@JsonView(Views.ViewClientEvenement.class)
	public List<ClientEvenement> list() {
		return clientEvenementRepo.findAll();
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewClientEvenement.class)
	public ClientEvenement find(@PathVariable Long id) {
		return clientEvenementRepo.findById(id).get();
	}

	@PostMapping("")
	@JsonView(Views.ViewClientEvenement.class)
	public ClientEvenement create(@RequestBody ClientEvenement clientEvenement) {
		clientEvenement = clientEvenementRepo.save(clientEvenement);

		return clientEvenement;
	}
	
	@PutMapping("/{id}")
	@JsonView(Views.ViewClientEvenement.class)
	public ClientEvenement update(@RequestBody ClientEvenement clientEvenement, @PathVariable Long id) {
		clientEvenement = clientEvenementRepo.save(clientEvenement);

		return clientEvenement;
	}
	
	@DeleteMapping("/{id}")
	@JsonView(Views.ViewClientEvenement.class)
	public void remove(@PathVariable Long id) {
		clientEvenementRepo.deleteById(id);
	}
}
