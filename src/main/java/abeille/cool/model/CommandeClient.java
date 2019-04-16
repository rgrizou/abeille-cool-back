package abeille.cool.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "commandeClient")
public class CommandeClient {
	private long id;
	private int version;
	private Date date;
	private Statut statut;
	private Coordonnee coordonee;
	private Client client;
	private Facturation facturation;
	private Array<LigneCommande> lignesCommande;
}
