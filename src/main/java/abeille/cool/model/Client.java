package abeille.cool.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

import abeille.cool.model.Views;


@Entity
public class Client {
	@Id
	@GeneratedValue
	@JsonView(Views.ViewCommon.class)
	private Long id;
	@Version
	@JsonView(Views.ViewCommon.class)
	private int version;
	@JsonView(Views.ViewCommon.class)
	private String nom;
	@JsonView(Views.ViewCommon.class)
	private String prenom;
	@JsonView(Views.ViewCommon.class)
	private boolean vip;
	@JsonView(Views.ViewCommon.class)
	private Integer fidelite;
	@OneToMany(mappedBy="client")
	private List<Avis> avis = new ArrayList<Avis>();
	@OneToMany(mappedBy="client")
	private List<CommandeClient> comclients = new ArrayList<CommandeClient>();
	@OneToMany(mappedBy="client")
	private List<Coordonnee> coordonnees = new ArrayList<Coordonnee>();
	@OneToMany(mappedBy="client")
	private List<ClientEvenement> clievents = new ArrayList<ClientEvenement>();
	@OneToOne(mappedBy="client")
	private Utilisateur utilisateur;
	
	public Client() {
		super();
	}

	public Client(String nom, String prenom, boolean vip, Integer fidelite) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.vip = vip;
		this.fidelite = fidelite;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public boolean isVip() {
		return vip;
	}

	public void setVip(boolean vip) {
		this.vip = vip;
	}

	public Integer getFidelite() {
		return fidelite;
	}

	public void setFidelite(Integer fidelite) {
		this.fidelite = fidelite;
	}

	public List<ClientEvenement> getClievents() {
		return clievents;
	}

	public void setClievents(List<ClientEvenement> clievents) {
		this.clievents = clievents;
	}

	public List<Avis> getAvis() {
		return avis;
	}

	public void setAvis(List<Avis> avis) {
		this.avis = avis;
	}

	public List<CommandeClient> getComclients() {
		return comclients;
	}

	public void setComclients(List<CommandeClient> comclients) {
		this.comclients = comclients;
	}

	public List<Coordonnee> getCoordonnees() {
		return coordonnees;
	}

	public void setCoordonnees(List<Coordonnee> coordonnees) {
		this.coordonnees = coordonnees;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
}
