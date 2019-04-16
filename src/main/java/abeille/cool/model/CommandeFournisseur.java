package abeille.cool.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class CommandeFournisseur {
	@Id
	@GeneratedValue
	@JsonView(Views.ViewCommon.class)
	private Long id;
	@Version
	@JsonView(Views.ViewCommon.class)
	private int version;
	@JsonView(Views.ViewCommon.class)
	private Integer qte;
	@JsonView(Views.ViewCommon.class)
	private Float prixTotal;
	@JsonView(Views.ViewCommon.class)
	private Integer tauxTVA;
	@JsonView(Views.ViewCommon.class)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;
	
//	@ManyToOne
//	@JoinColumn(name="administrateur_id")
//	@JsonView(Views.ViewCommon.class)
//	private Administrateur administrateur;
//	@ManyToOne()
//	@JoinColumn(name="produit_id")
//	@JsonView(Views.ViewCommon.class)
//	private Produit produit;
	
	

	public CommandeFournisseur(Integer qte, Float prixTotal, Integer tauxTVA, Date date) {
		super();
		this.qte = qte;
		this.prixTotal = prixTotal;
		this.tauxTVA = tauxTVA;
		this.date = date;
	}


	public CommandeFournisseur() {
		super();
	}

//
//	public Administrateur getAdministrateur() {
//		return administrateur;
//	}
//
//
//	public void setAdministrateur(Administrateur administrateur) {
//		this.administrateur = administrateur;
//	}
//
//
//	public Produit getProduit() {
//		return produit;
//	}
//
//
//	public void setProduit(Produit produit) {
//		this.produit = produit;
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


	public Integer getQte() {
		return qte;
	}


	public void setQte(Integer qte) {
		this.qte = qte;
	}


	public Float getPrixTotal() {
		return prixTotal;
	}


	public void setPrixTotal(Float prixTotal) {
		this.prixTotal = prixTotal;
	}


	public Integer getTauxTVA() {
		return tauxTVA;
	}


	public void setTauxTVA(Integer tauxTVA) {
		this.tauxTVA = tauxTVA;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


}
