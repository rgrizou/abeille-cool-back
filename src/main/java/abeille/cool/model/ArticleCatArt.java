package abeille.cool.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

import abeille.cool.model.Views.ViewCommon;

@Entity
public class ArticleCatArt {
	@Id
	@GeneratedValue
	@JsonView(ViewCommon.class)
	private Long id;
	@Version
	@JsonView(Views.ViewCommon.class)
	private int version;
	@ManyToOne
	@JoinColumn(name = "catArt_id")
	private CatArt catArt;
	@ManyToOne
	@JoinColumn(name = "article_id")
	private Article article;

	public ArticleCatArt() {
		super();
	}
	
	public CatArt getCatArt() {
		return catArt;
	}

	public void setCatArt(CatArt catArt) {
		this.catArt = catArt;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
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

}
