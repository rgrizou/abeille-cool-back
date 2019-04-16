package abeille.cool.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

import abeille.cool.model.Views.ViewCommon;

@Entity
public class Article {
	@Id
	@GeneratedValue
	@JsonView(ViewCommon.class)
	private Long id;
	@Version
	@JsonView(ViewCommon.class)
	private int version;
	@Column
	@JsonView(ViewCommon.class)
	private String nom;
	@Column
	@JsonView(ViewCommon.class)
	private String detail;
	@Column
	@JsonView(ViewCommon.class)
	private Float prix;
	@Column
	@JsonView(ViewCommon.class)
	private Integer qte;
	@Column
	@JsonView(ViewCommon.class)
	private String photoURL;
	@Column
	@JsonView(ViewCommon.class)
	private Float degreAlcool;
	@Column
	@JsonView(ViewCommon.class)
	private Integer volume;
	@Column
	@JsonView(ViewCommon.class)
	private String typeMiel;
	@Column
	@Enumerated(EnumType.STRING)
	@JsonView(ViewCommon.class)
	private TypeHydromel typeHydromel;
	@Column
	@JsonView(ViewCommon.class)
	private boolean archive;
//	@Column
//	@JsonView(ViewCommon.class)
//	private List<Avis> avis = new ArrayList<Avis>();
//	@Column
//	@JsonView(ViewCommon.class)
//	private List<LigneCommande> ligneCommande = new ArrayList<LigneCommande>();
//	@Column
//	@JsonView(ViewCommon.class)
//	private List<CatArt> catArt = new ArrayList<CatArt>();
//	@Column
//	@JsonView(ViewCommon.class)
//	private List<ArticleCatArt> articleCatArt = new ArrayList<ArticleCatArt>();

	public Article() {
		super();
	}

	public Article(String nom, Float prix, Integer volume) {
		super();
		this.nom = nom;
		this.prix = prix;
		this.volume = volume;
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

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public Float getPrix() {
		return prix;
	}

	public void setPrix(Float prix) {
		this.prix = prix;
	}

	public Integer getQte() {
		return qte;
	}

	public void setQte(Integer qte) {
		this.qte = qte;
	}

	public String getPhotoURL() {
		return photoURL;
	}

	public void setPhotoURL(String photoURL) {
		this.photoURL = photoURL;
	}

	public Float getDegreAlcool() {
		return degreAlcool;
	}

	public void setDegreAlcool(Float degreAlcool) {
		this.degreAlcool = degreAlcool;
	}

	public Integer getVolume() {
		return volume;
	}

	public void setVolume(Integer volume) {
		this.volume = volume;
	}

	public String getTypeMiel() {
		return typeMiel;
	}

	public void setTypeMiel(String typeMiel) {
		this.typeMiel = typeMiel;
	}

	public TypeHydromel getTypeHydromel() {
		return typeHydromel;
	}

	public void setTypeHydromel(TypeHydromel typeHydromel) {
		this.typeHydromel = typeHydromel;
	}

	public boolean isArchive() {
		return archive;
	}

	public void setArchive(boolean archive) {
		this.archive = archive;
	}

}
