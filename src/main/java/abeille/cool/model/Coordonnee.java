package abeille.cool.model;

import java.util.ArrayList;
import java.util.List;

public class Coordonnee {
	private Long id;
	private Long version;
	private String libelle;
	private String nom; 
	private String prenom;
	private Long numTel;
	private String mail;
	private String rue;
	private String codePostal;
	private String ville;
	private String pays;
	private Client client;
	private List<CommandeClient> commandeClients = new ArrayList<CommandeClient>();
	
	public Coordonnee() {
		super();
	}
	
	
	public Coordonnee(String libelle, String nom, String prenom, Long numTel, String mail, String rue,
			String codePostal, String ville, String pays) {
		super();
		this.libelle = libelle;
		this.nom = nom;
		this.prenom = prenom;
		this.numTel = numTel;
		this.mail = mail;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.pays = pays;
	}


	public Coordonnee(String libelle, String nom, String prenom, Long numTel, String mail, String rue,
			String codePostal, String ville, String pays, Client client, List<CommandeClient> commandeClients) {
		super();
		this.libelle = libelle;
		this.nom = nom;
		this.prenom = prenom;
		this.numTel = numTel;
		this.mail = mail;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.pays = pays;
		this.client = client;
		this.commandeClients = commandeClients;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getVersion() {
		return version;
	}
	public void setVersion(Long version) {
		this.version = version;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
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
	public Long getNumTel() {
		return numTel;
	}
	public void setNumTel(Long numTel) {
		this.numTel = numTel;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}

	public List<CommandeClient> getCommandeClients() {
		return commandeClients;
	}


	public void setCommandeClients(List<CommandeClient> commandeClients) {
		this.commandeClients = commandeClients;
	}	
	
}
