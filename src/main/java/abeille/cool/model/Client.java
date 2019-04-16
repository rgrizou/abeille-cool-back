package abeille.cool.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;

//import java.util.List;

@Entity
public class Client {
	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	
	private String nom;
	private String prenom;
	private boolean vip;
	private Integer fidelite;
//	private List<Avis> avis = ArrayList<Avis>;
//	private List<CommandeClient> comclients = ArrayList<CommandeClient>;
//	private List<Coordonnee> coordonnees = ArrayList<Coordonnee>;
//	private List<ClientEvenement> clievents = ArrayList<ClientEvenement>;
//	private Utilisateur utilisateur;
	
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
	
}
