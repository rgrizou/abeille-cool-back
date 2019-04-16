package abeille.cool.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonView;

import abeille.cool.model.Views.ViewCommon;


@Entity
public class Avis {
	@Id
	@GeneratedValue
	@JsonView(ViewCommon.class)
	private Long id;
	@Version
	@JsonView(ViewCommon.class)
	private Long version;
	@JsonView(ViewCommon.class)
	private Date date;
	@Column(name = "avis", length = 500)
	@JsonView(ViewCommon.class)
	@Size(min = 1, max=500, message="L'avis est trop long. (max 500 caractères))")
	private String avis;
	@JsonView(ViewCommon.class)
	private Integer note;
	@JsonView(ViewCommon.class)
	private boolean valide;
	@JsonView(ViewCommon.class)
	private boolean site;
	@JsonView(ViewCommon.class)
	@Transient
	private Client client;
	@JsonView(ViewCommon.class)
	@Transient
	private Article article;
	
	
	public Avis() {
		super();
	}
		
	public Avis(Date date, String avis, Integer note, boolean valide, boolean site) {
		super();
		this.date = date;
		this.avis = avis;
		this.note = note;
		this.valide = valide;
		this.site = site;
	}

	public Avis(Date date, String avis, Integer note, boolean valide, boolean site, Client client, Article article) {
		super();
		this.date = date;
		this.avis = avis;
		this.note = note;
		this.valide = valide;
		this.site = site;
		this.client = client;
		this.article = article;
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getAvis() {
		return avis;
	}
	public void setAvis(String avis) {
		this.avis = avis;
	}
	public Integer getNote() {
		return note;
	}
	public void setNote(Integer note) {
		this.note = note;
	}
	public boolean isValide() {
		return valide;
	}
	public void setValide(boolean valide) {
		this.valide = valide;
	}
	public boolean isSite() {
		return site;
	}
	public void setSite(boolean site) {
		this.site = site;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	
	
	
}
