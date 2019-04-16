package abeille.cool.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Utilisateur {
	@Id
	@GeneratedValue
	@JsonView(Views.ViewCommon.class)
	private Long id;
	@Version
	@JsonView(Views.ViewCommon.class)
	private int version;
	@Column(length = 100)
	@JsonView(Views.ViewCommon.class)
	private String mail;
	@Column(length = 50)
	@JsonView(Views.ViewCommon.class)
	private String mdp;
	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	@JsonView(Views.ViewCommon.class)
	private TypeUtilisateur type;
	@JsonView(Views.ViewCommon.class)
	@OneToOne
	@JoinColumn(name="client_id")
	private Client client;
	@JsonView(Views.ViewCommon.class)
	@OneToOne
	@JoinColumn(name="fournisseur_id")
	private Fournisseur fournisseur;
//	@OneToOne()
//	@JsonView(Views.ViewCommon.class)
//	@JoinColumn(name="administrateur_id")
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
