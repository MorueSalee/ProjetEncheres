package fr.formation.enchere.bo;

import java.time.LocalDate;

public class Enchere {
	
	private Integer noEnchere;
	private Utilisateur utilisateur;
	private ArticleVendu articleVendu;
	private LocalDate dateEnchere;
	private Integer montantEnchere;

	public Enchere() {
	}

	public Enchere(Utilisateur utilisateur, ArticleVendu articleVendu, LocalDate dateEnchere, Integer montantEnchere) {
		super();
		this.utilisateur = utilisateur;
		this.articleVendu = articleVendu;
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
	}

	public Enchere(Integer noEnchere, Utilisateur utilisateur, ArticleVendu articleVendu, LocalDate dateEnchere,
			Integer montantEnchere) {
		super();
		this.noEnchere = noEnchere;
		this.utilisateur = utilisateur;
		this.articleVendu = articleVendu;
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
	}

	public Integer getNoEnchere() {
		return noEnchere;
	}

	public void setNoEnchere(Integer noEnchere) {
		this.noEnchere = noEnchere;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public ArticleVendu getArticleVendu() {
		return articleVendu;
	}

	public void setArticleVendu(ArticleVendu articleVendu) {
		this.articleVendu = articleVendu;
	}

	public LocalDate getDateEnchere() {
		return dateEnchere;
	}

	public void setDateEnchere(LocalDate dateEnchere) {
		this.dateEnchere = dateEnchere;
	}

	public Integer getMontantEnchere() {
		return montantEnchere;
	}

	public void setMontantEnchere(Integer montantEnchere) {
		this.montantEnchere = montantEnchere;
	}

	@Override
	public String toString() {
		return "Enchere [noEnchere=" + noEnchere + ", utilisateur=" + utilisateur + ", articleVendu=" + articleVendu
				+ ", dateEnchere=" + dateEnchere + ", montantEnchere=" + montantEnchere + "]";
	}

}
