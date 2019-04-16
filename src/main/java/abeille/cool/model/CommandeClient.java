package abeille.cool.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

import abeille.cool.model.Views.ViewCommon;

@Entity
public class CommandeClient {
	@Id
	@JsonView(Views.ViewCommon.class)
	private long id;
	@Version
	private int version;
	@Column(name = "date")
	@Temporal(TemporalType.DATE)
	@JsonView(ViewCommon.class)
	private Date date;
	@Column(name = "statut", length = 20, nullable = false)
	@Enumerated(EnumType.STRING)
	@JsonView(ViewCommon.class)
	private Statut statut;
	@ManyToOne
	private Coordonnee coordonee;
	@ManyToOne
	private Client client;
//	@OneToOne
//	private Facturation facturation;
//	@OneToMany(mappedby="commandeClient")
//	private Array<LigneCommande> lignesCommande;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Statut getStatut() {
		return statut;
	}
	public void setStatut(Statut statut) {
		this.statut = statut;
	}
	public Coordonnee getCoordonee() {
		return coordonee;
	}
	public void setCoordonee(Coordonnee coordonee) {
		this.coordonee = coordonee;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
//	public Facturation getFacturation() {
//		return facturation;
//	}
//	public void setFacturation(Facturation facturation) {
//		this.facturation = facturation;
//	}
//	public Array<LigneCommande> getLignesCommande() {
//		return lignesCommande;
//	}
//	public void setLignesCommande(Array<LigneCommande> lignesCommande) {
//		this.lignesCommande = lignesCommande;
//	}
	public CommandeClient(long id, int version, Date date, Statut statut) {
		super();
		this.id = id;
		this.version = version;
		this.date = date;
		this.statut = statut;
	}
}
