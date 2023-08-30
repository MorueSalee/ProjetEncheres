package fr.formation.enchere.ihm.model;

import java.util.ArrayList;
import java.util.List;

import fr.formation.enchere.bo.ArticleVendu;

public class ArticleVenduModel {
	
	private String message = "";
	private List<ArticleVendu> listArticle = new ArrayList<>();

	public ArticleVenduModel() {
	}

	public ArticleVenduModel(String message, List<ArticleVendu> listArticle) {
		super();
		this.message = message;
		this.listArticle = listArticle;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<ArticleVendu> getListArticle() {
		return listArticle;
	}

	public void setListArticle(List<ArticleVendu> listArticle) {
		this.listArticle = listArticle;
	}

	@Override
	public String toString() {
		return "ArticleVenduModel [message=" + message + ", listArticle=" + listArticle + "]";
	}

	

}
