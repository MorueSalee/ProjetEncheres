package fr.formation.enchere.bo;

import java.time.LocalDate;

public class Enchere {
	
	private Integer noEnchere;
	private LocalDate dateEnchere;
	private Integer montantEnchere;
	private Integer noUtilisateur;
	private Utilisateur utilisateur;
	private ArticleVendu articleVendu;

	public Enchere() {
	}
	
	

	public Enchere(Integer noEnchere, LocalDate dateEnchere, Integer montantEnchere) {
		super();
		this.noEnchere = noEnchere;
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
	}
	
	public Enchere(Integer noEnchere, LocalDate dateEnchere, Integer montantEnchere, Integer noUtilisateur) {
		super();
		this.noEnchere = noEnchere;
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
		this.noUtilisateur = noUtilisateur;
	}

	public Enchere(LocalDate dateEnchere, Integer montantEnchere, Utilisateur utilisateur, ArticleVendu articleVendu) {
		super();
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
		this.utilisateur = utilisateur;
		this.articleVendu = articleVendu;
	}

	public Enchere(Integer noEnchere, LocalDate dateEnchere, Integer montantEnchere, Utilisateur utilisateur,
			ArticleVendu articleVendu) {
		super();
		this.noEnchere = noEnchere;
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
		this.utilisateur = utilisateur;
		this.articleVendu = articleVendu;
	}

	public Integer getNoEnchere() {
		return noEnchere;
	}

	public void setNoEnchere(Integer noEnchere) {
		this.noEnchere = noEnchere;
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

	public Integer getNoUtilisateur() {
		return noUtilisateur;
	}



	public void setNoUtilisateur(Integer noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
	}

	@Override
	public String toString() {
		return "Enchere [noEnchere=" + noEnchere + ", dateEnchere=" + dateEnchere + ", montantEnchere=" + montantEnchere
				+ ", utilisateur=" + utilisateur + ", articleVendu=" + articleVendu + "]";
	}
	
	public void addUtilisateur(Utilisateur u) {
		u.addEnchere(this);
	}
	
	public void addArticle(ArticleVendu a) {
		a.addEnchere(this);
	}
	
}
