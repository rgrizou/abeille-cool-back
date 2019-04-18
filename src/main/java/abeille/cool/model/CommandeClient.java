package abeille.cool.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

import abeille.cool.model.Views.ViewCommon;

@Entity
public class CommandeClient {
	@Id
	@GeneratedValue
	@JsonView(ViewCommon.class)
	private long id;
	@Version
	@JsonView(Views.ViewCommon.class)
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
	@JoinColumn(name="coordonnee_id")
	private Coordonnee coordonnee;
	@ManyToOne
	@JoinColumn(name="client_id")
	private Client client;
	@OneToOne
	@JoinColumn(name="facturation_id")
	private Facturation facturation;
	@OneToMany(mappedBy="commandeClient")
	private List<LigneCommande> lignesCommande = new ArrayList<LigneCommande>();
	
	public CommandeClient() {
		super();
	}
	
	public CommandeClient(Date date, Statut statut) {
		super();
		this.date = date;
		this.statut = statut;
	}
	
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
	
	public Coordonnee getCoordonnee() {
		return coordonnee;
	}
	
	public void setCoordonnee(Coordonnee coordonnee) {
		this.coordonnee = coordonnee;
	}
	
	public Client getClient() {
		return client;
	}
	
	public void setClient(Client client) {
		this.client = client;
	}
	
	public Facturation getFacturation() {
		return facturation;
	}
	
	public void setFacturation(Facturation facturation) {
		this.facturation = facturation;
	}
	
	public List<LigneCommande> getLignesCommande() {
		return lignesCommande;
	}
	
	public void setLignesCommande(List<LigneCommande> lignesCommande) {
		this.lignesCommande = lignesCommande;
	}

}
