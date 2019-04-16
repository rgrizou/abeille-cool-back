package abeille.cool.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
//import javax.persistence.OneToMany;
//import javax.persistence.OneToOne;
import javax.persistence.Version;
import javax.validation.constraints.NotEmpty;

@Entity
public class Administrateur {

	@Id
	@GeneratedValue
	private Long id; 
	@Version
	private int version; 
	@Column(name= "nom", length=30)
	@NotEmpty(message="Le nom doit être renseigné.")
	private String nom; 
	@Column(name= "prenom", length=30)
	@NotEmpty(message="Le nom doit être renseigné.")
	private String prenom; 
	@Column(name= "rue", length=30)
	private String rue; 
	@Column(name= "codePostal", length=30)
	private String codePostal; 
	@Column(name= "ville", length=30)
	private String ville; 
	@Column(name= "pays", length=30)
	private String pays;
	@OneToOne(mappedBy = "administrateur")
	private Utilisateur utilisateur; 
	@OneToMany(mappedBy ="administrateur") // mappé avec l'attribut dans la classe commandeFournisseur
	private CommandeFournisseur commandeFournisseur; 
	
	
	public Administrateur() {
		super();
	}

	public Administrateur(Long id, String nom, String prenom, String rue, String codePostal, String ville,
			String pays) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.pays = pays;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public CommandeFournisseur getCommandeFournisseur() {
		return commandeFournisseur;
	}

	public void setCommandeFournisseur(CommandeFournisseur commandeFournisseur) {
		this.commandeFournisseur = commandeFournisseur;
	} 

}
