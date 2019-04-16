package abeille.cool.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity
public class Utilisateur {
	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	@Column(length = 100)
	private String mail;
	@Column(length = 50)
	private String mdp;
	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private TypeUtilisateur type;
	
//	@OneToOne()
//	private Client client;
//	@OneToOne()
//	private Fournisseur fournisseur;
//	@OneToOne()
//	private Administrateur administrateur;

	public Utilisateur() {
		super();
	}

	public Utilisateur(String mail, String mdp, TypeUtilisateur type) {
		super();
		this.mail = mail;
		this.mdp = mdp;
		this.type = type;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public TypeUtilisateur getType() {
		return type;
	}

	public void setType(TypeUtilisateur type) {
		this.type = type;
	}

//	public Client getClient() {
//		return client;
//	}
//
//	public void setClient(Client client) {
//		this.client = client;
//	}
//
//	public Fournisseur getFournisseur() {
//		return fournisseur;
//	}
//
//	public void setFournisseur(Fournisseur fournisseur) {
//		this.fournisseur = fournisseur;
//	}
//
//	public Administrateur getAdministrateur() {
//		return administrateur;
//	}
//
//	public void setAdministrateur(Administrateur administrateur) {
//		this.administrateur = administrateur;
//	}

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

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

}
