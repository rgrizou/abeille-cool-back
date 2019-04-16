package abeille.cool.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

import abeille.cool.model.Views.ViewCommon;

@Entity
public class LigneCommande {
	@Id
	@GeneratedValue
	@JsonView(ViewCommon.class)
	private Long id;
	@Version
	@JsonView(ViewCommon.class)
	private Long version;
	@JsonView(ViewCommon.class)
	private Integer qte;
	@JsonView(ViewCommon.class)
	private Article article;
	@JsonView(ViewCommon.class)
	private CommandeClient commandeClient;
	
	public LigneCommande() {
		super();
	}
	
	public LigneCommande(Integer qte) {
		super();
		this.qte = qte;
	}

	public LigneCommande(Integer qte, Article article, CommandeClient commandeClient) {
		super();
		this.qte = qte;
		this.article = article;
		this.commandeClient = commandeClient;
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

	public Integer getQte() {
		return qte;
	}

	public void setQte(Integer qte) {
		this.qte = qte;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public CommandeClient getCommandeClient() {
		return commandeClient;
	}

	public void setCommandeClient(CommandeClient commandeClient) {
		this.commandeClient = commandeClient;
	}
	
	
}
