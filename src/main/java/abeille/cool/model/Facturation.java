package abeille.cool.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonView;

import abeille.cool.model.Views.ViewCommon;
import abeille.cool.model.Views.ViewFacturationWithCommandeCLient;


@Entity
public class Facturation {
	@Id
	@GeneratedValue
	@JsonView(ViewCommon.class)
	private Long id;
	@Version
	@JsonView(ViewCommon.class)
	private int version;
	@Temporal(TemporalType.DATE)
	@Column
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonView(ViewCommon.class)
	private Date date;
	@Column(length=100)
	@JsonView(ViewCommon.class)
	private String ref;
	@OneToOne(mappedBy = "facturation")
	@JsonView(ViewFacturationWithCommandeCLient.class)
	private CommandeClient commandeClient;
	
	
	public Facturation() {
		super();
	}


	public Facturation(Long id, Date date, String ref) {
		super();
		this.id = id;
		this.date = date;
		this.ref = ref;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public String getRef() {
		return ref;
	}


	public void setRef(String ref) {
		this.ref = ref;
	}


	public CommandeClient getCommandeClient() {
		return commandeClient;
	}


	public void setCommandeClient(CommandeClient commandeClient) {
		this.commandeClient = commandeClient;
	}
	

	
}
