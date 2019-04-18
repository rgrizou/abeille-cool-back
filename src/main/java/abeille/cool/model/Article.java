package abeille.cool.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	@JsonView(Views.ViewCommon.class)
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
	@OneToMany(mappedBy = "article")
	private List<Avis> avis = new ArrayList<Avis>();
	@OneToMany(mappedBy = "article")
	private List<LigneCommande> ligneCommande = new ArrayList<LigneCommande>();
	@OneToMany(mappedBy = "article")
	private List<ArticleCatArt> articleCatArt = new ArrayList<ArticleCatArt>();

	public Article() {
		super();
	}
	
	public Article(String nom, String detail, Float prix, Integer qte, String photoURL,
			Float degreAlcool, Integer volume, String typeMiel, TypeHydromel typeHydromel, boolean archive) {
		super();
		this.nom = nom;
		this.detail = detail;
		this.prix = prix;
		this.qte = qte;
		this.photoURL = photoURL;
		this.degreAlcool = degreAlcool;
		this.volume = volume;
		this.typeMiel = typeMiel;
		this.typeHydromel = typeHydromel;
		this.archive = archive;
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

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public List<Avis> getAvis() {
		return avis;
	}

	public void setAvis(List<Avis> avis) {
		this.avis = avis;
	}

	public List<LigneCommande> getLigneCommande() {
		return ligneCommande;
	}

	public void setLigneCommande(List<LigneCommande> ligneCommande) {
		this.ligneCommande = ligneCommande;
	}

	public List<ArticleCatArt> getArticleCatArt() {
		return articleCatArt;
	}

	public void setArticleCatArt(List<ArticleCatArt> articleCatArt) {
		this.articleCatArt = articleCatArt;
	}

}
