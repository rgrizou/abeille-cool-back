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

import abeille.cool.model.Client;
import abeille.cool.model.Views;
import abeille.cool.repository.IClientRepository;

@RestController
@RequestMapping("/api/client")
@CrossOrigin("*")
public class LigneCommandeRestController {
	@Autowired
	private IClientRepository clientRepo;

	@GetMapping("")
	@JsonView(Views.ViewClient.class)
	public List<Client> list() {
		return clientRepo.findAll();
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewClient.class)
	public Client find(@PathVariable Long id) {
		return clientRepo.findById(id).get();
	}

	@PostMapping("")
	@JsonView(Views.ViewClient.class)
	public Client create(@RequestBody Client client) {
		client = clientRepo.save(client);

		return client;
	}
	
	@PutMapping("/{id}")
	@JsonView(Views.ViewClient.class)
	public Client update(@RequestBody Client client,@PathVariable Long id) {
		client = clientRepo.save(client);

		return client;
	}
	
	@DeleteMapping("/{id}")
	@JsonView(Views.ViewClient.class)
	public void remove(@PathVariable Long id) {
		clientRepo.deleteById(id);
	}

}
