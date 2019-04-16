package abeille.cool.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

import abeille.cool.model.Views.ViewCommon;

@Entity
public class CatArt {
	@Id
	@GeneratedValue
	@JsonView(ViewCommon.class)
	private Long id;
	@Version
	@JsonView(ViewCommon.class)
	private int version;
	@Column
	@JsonView(ViewCommon.class)
	private Integer qte;
	@OneToMany(mappedBy="catArt")
	private List<ArticleCatArt> articleCatArt = new ArrayList<ArticleCatArt>();

	public CatArt() {
		super();
	}

	public CatArt(Integer qte) {
		super();
		this.qte = qte;
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

	public Integer getQte() {
		return qte;
	}

	public void setQte(Integer qte) {
		this.qte = qte;
	}

	public List<ArticleCatArt> getArticleCatArt() {
		return articleCatArt;
	}

	public void setArticleCatArt(List<ArticleCatArt> articleCatArt) {
		this.articleCatArt = articleCatArt;
	}

}
