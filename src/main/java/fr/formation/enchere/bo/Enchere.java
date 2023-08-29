package fr.formation.enchere.bo;

import java.time.LocalDate;

public class Enchere {
	
	private Integer noEnchere;
	private Integer noUtilisateur;
	private Integer noArticle;
	private LocalDate dateEnchere;
	private Integer montantEnchere;

	public Enchere() {
	}

	public Enchere(Integer noEnchere, Integer noUtilisateur, Integer noArticle, LocalDate dateEnchere,
			Integer montantEncher) {
		super();
		this.noEnchere = noEnchere;
		this.noUtilisateur = noUtilisateur;
		this.noArticle = noArticle;
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEncher;
	}

	public Integer getNoEnchere() {
		return noEnchere;
	}

	public void setNoEnchere(Integer noEnchere) {
		this.noEnchere = noEnchere;
	}

	public Integer getNoUtilisateur() {
		return noUtilisateur;
	}

	public void setNoUtilisateur(Integer noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
	}

	public Integer getNoArticle() {
		return noArticle;
	}

	public void setNoArticle(Integer noArticle) {
		this.noArticle = noArticle;
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
	
	

}
