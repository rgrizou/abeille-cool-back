package abeille.cool.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.Version;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonView;

import abeille.cool.model.Views.ViewCommon;



@Entity
public class Evenement {
	@Id
	@GeneratedValue
	@JsonView(ViewCommon.class)
	private Long id;
	@Version
	@JsonView(ViewCommon.class)
	private int version;
	@Temporal(TemporalType.DATE)
	@Column(name="date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonView(ViewCommon.class)
	private Date date;
	@Column(length=100)
	@JsonView(ViewCommon.class)
	private String lieu;
	@Column(name="descriptif")
	@JsonView(ViewCommon.class)
	private String descriptif;
	@Column(name="photoURL")
	@JsonView(ViewCommon.class)
	private String photoURL;
//	@Transient
//	private List<ClientEvenement> clientEvenements = new ArrayList<ClientEvenement>();
	
	
	
	public Evenement() {
		super();
	}

	public Evenement(Long id, Date date, String lieu, String descriptif, String photoURL) {
		super();
		this.id = id;
		this.date = date;
		this.lieu = lieu;
		this.descriptif = descriptif;
		this.photoURL = photoURL;
	}

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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	public String getDescriptif() {
		return descriptif;
	}

	public void setDescriptif(String descriptif) {
		this.descriptif = descriptif;
	}

	public String getPhotoURL() {
		return photoURL;
	}

	public void setPhotoURL(String photoURL) {
		this.photoURL = photoURL;
	}

}
