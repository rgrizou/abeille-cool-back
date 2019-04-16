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
@Table(name = "commande_client") 
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
	@OneToOne
	private Facturation facturation;
	@OneToMany(mappedby="commandeClient")
	private Array<LigneCommande> lignesCommande;
}
