package abeille.cool.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;
import abeille.cool.model.Views;
//import java.util.List;


@Entity
public class Fournisseur {
	@Id
	@GeneratedValue
	@JsonView(Views.ViewCommon.class)
	private Long id;
	@Version
	private int version;
	@JsonView(Views.ViewCommon.class)
	private String raisonSociale;
	@JsonView(Views.ViewCommon.class)
	private String siret;
	@JsonView(Views.ViewCommon.class)
	private String statutJuridique;
	@JsonView(Views.ViewCommon.class)
	private String numeroTva;
//	@OneToMany(mappedBy="")
//	private List<Produit> produits = ArrayList<Produit>;
//	@OneToOne(mappedBy="")
//	private Utilisateur utilisateur;
	public Fournisseur() {
		super();
	}
public Fournisseur(Long id, int version, String raisonSociale, String siret, String statutJuridique, String numeroTva) {
	super();
	this.id = id;
	this.version = version;
	this.raisonSociale = raisonSociale;
	this.siret = siret;
	this.statutJuridique = statutJuridique;
	this.numeroTva = numeroTva;
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
public String getRaisonSociale() {
	return raisonSociale;
}
public void setRaisonSociale(String raisonSociale) {
	this.raisonSociale = raisonSociale;
}
public String getSiret() {
	return siret;
}
public void setSiret(String siret) {
	this.siret = siret;
}
public String getStatutJuridique() {
	return statutJuridique;
}
public void setStatutJuridique(String statutJuridique) {
	this.statutJuridique = statutJuridique;
}
public String getNumeroTva() {
	return numeroTva;
}
public void setNumeroTva(String numeroTva) {
	this.numeroTva = numeroTva;
}
	

}
