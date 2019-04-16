package abeille.cool.model;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Version;


import com.fasterxml.jackson.annotation.JsonView;


@Entity
public class Produit {
	@Id
	@GeneratedValue
	@JsonView(Views.ViewCommon.class)
	private Long id;
	@Version
	private int version;
	@JsonView(Views.ViewCommon.class)
	private String nom;
	@JsonView(Views.ViewCommon.class)
	private String description;
	@JsonView(Views.ViewCommon.class)
	private Integer qte;
	@JsonView(Views.ViewCommon.class)
	private Float prixUnitaireHT;
	@Enumerated(EnumType.STRING)
	@JsonView(Views.ViewCommon.class)
	private Unite unite;
	@ManyToOne
	@JoinColumn (name ="fournisseur_id")
	private Fournisseur fournisseur;
	@OneToMany(mappedBy = "produit")
	private List<CommandeFournisseur> commandeFournisseurs = new ArrayList<CommandeFournisseur>();
	@OneToMany(mappedBy = "produit")
	private List<ProduitCatProd> ProduitCatProds = new ArrayList<ProduitCatProd>();
	
	
	public Produit() {
		super();
	}	
	
	public Produit(String nom, String description, Integer qte, Float prixUnitaireHT, Unite unite) {
		super();
		this.nom = nom;
		this.description = description;
		this.qte = qte;
		this.prixUnitaireHT = prixUnitaireHT;
		this.unite = unite;
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
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Integer getQte() {
		return qte;
	}
	
	public void setQte(Integer qte) {
		this.qte = qte;
	}
	
	public Float getPrixUnitaireHT() {
		return prixUnitaireHT;
	}
	
	public void setPrixUnitaireHT(Float prixUnitaireHT) {
		this.prixUnitaireHT = prixUnitaireHT;
	}
	
	public Unite getUnite() {
		return unite;
	}
	
	public void setUnite(Unite unite) {
		this.unite = unite;
	}

	public Fournisseur getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}

	public List<CommandeFournisseur> getCommandeFournisseurs() {
		return commandeFournisseurs;
	}

	public void setCommandeFournisseurs(List<CommandeFournisseur> commandeFournisseurs) {
		this.commandeFournisseurs = commandeFournisseurs;
	}

	public List<ProduitCatProd> getProduitCatProds() {
		return ProduitCatProds;
	}

	public void setProduitCatProds(List<ProduitCatProd> produitCatProds) {
		ProduitCatProds = produitCatProds;
	}

}
