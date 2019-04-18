package abeille.cool.web.rest;

import java.io.Console;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import abeille.cool.model.Administrateur;
import abeille.cool.model.Client;
import abeille.cool.model.Fournisseur;
import abeille.cool.model.TypeUtilisateur;
import abeille.cool.model.Utilisateur;
import abeille.cool.model.Views;
import abeille.cool.repository.IAdministrateurRepository;
import abeille.cool.repository.IClientRepository;
import abeille.cool.repository.IFournisseurRepository;
import abeille.cool.repository.IUtilisateurRepository;

@RestController
@RequestMapping("/utilisateur")
@CrossOrigin("*")
public class UtilisateurRestController {

	@Autowired
	private IUtilisateurRepository utilisateurRepo;
	@Autowired
	private IClientRepository clientRepo;
	@Autowired
	private IFournisseurRepository fournisseurRepo;
	@Autowired
	private IAdministrateurRepository administrateurRepo;

	@GetMapping("")
	@JsonView(Views.ViewUtilisateur.class)
	public List<Utilisateur> list() {
		return utilisateurRepo.findAll();
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewUtilisateur.class)
	public Utilisateur find(@PathVariable Long id) {
		return utilisateurRepo.findById(id).get();
	}

	@PostMapping("/existmail")
	@JsonView(Views.ViewUtilisateur.class)
	public Boolean existMail(@RequestBody String existmail) {
		List<Utilisateur> utilisateurs=utilisateurRepo.findAll();
		if(!utilisateurs.isEmpty()) {
			for(Utilisateur u:utilisateurs) {
				if(u.getMail().contentEquals(existmail)) {
					return true;
				}
			}
		}
		return false;
	}
	
	@PostMapping("/login")
	@JsonView(Views.ViewUtilisateur.class)
	public Long login(@RequestBody Utilisateur utilisateur) {
		List<Utilisateur> utilisateurs=utilisateurRepo.findAll();
		if(!utilisateurs.isEmpty()) {
			for(Utilisateur u:utilisateurs) {
				if((u.getMail().contentEquals(utilisateur.getMail()) &&(u.getMdp().contentEquals(utilisateur.getMdp())))) {
					return u.getId();
				}
			}
		}
		return 0L;
	}
	
	@PostMapping("")
	@JsonView(Views.ViewUtilisateur.class)
	public Utilisateur create(@RequestBody Utilisateur utilisateur) {
		if(utilisateur.getType()==TypeUtilisateur.CLIENT) {
			Client client = new Client();
			client=clientRepo.save(client);
			utilisateur.setClient(client);
		}else if(utilisateur.getType()==TypeUtilisateur.FOURNISSEUR) {
			Fournisseur fournisseur = new Fournisseur();
			fournisseur=fournisseurRepo.save(fournisseur);
			utilisateur.setFournisseur(fournisseur);
		}else if(utilisateur.getType()==TypeUtilisateur.ADMINISTRATEUR) {
			Administrateur administrateur = new Administrateur();
			administrateur=administrateurRepo.save(administrateur);
			utilisateur.setAdministrateur(administrateur);
			}
		utilisateur = utilisateurRepo.save(utilisateur);
		return utilisateur;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewUtilisateur.class)
	public Utilisateur update(@RequestBody Utilisateur utilisateur, @PathVariable Long id) {
		utilisateur = utilisateurRepo.save(utilisateur);
		return utilisateur;
	}

	@DeleteMapping("/{id}")
	@JsonView(Views.ViewUtilisateur.class)
	public void remove(@PathVariable Long id) {
		utilisateurRepo.deleteById(id);
	}

}
