package abeille.cool.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;
 
@Entity
public class Actualite {
	@Id
	@GeneratedValue
	private Long id; 
	@Version
	private int version; 
	@Column(name= "titre", length=350)
	private String titre;
	@Column(name= "descriptif", length=6000)
	private String descriptif; 
	@Column(name= "date", length=30)
	private Date date; 
	private String photoUrl; 
	private Boolean active;
	
	public Actualite() {
		super();
	}

	public Actualite(String titre, String descriptif, Date date, String photoUrl, Boolean active) {
		super();
		this.titre = titre;
		this.descriptif = descriptif;
		this.date = date;
		this.photoUrl = photoUrl;
		this.active = active;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescriptif() {
		return descriptif;
	}

	public void setDescriptif(String descriptif) {
		this.descriptif = descriptif;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	} 
	
}
