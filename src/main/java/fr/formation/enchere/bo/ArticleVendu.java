package fr.formation.enchere.bo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ArticleVendu {
	private Integer noArticle;
	private String nomArticle;
	private String description;
	private LocalDate dateDebutEncheres;
	private LocalDate dateFinEncheres;
	private Integer prixInitial;
	private Integer prixVente;
	private Utilisateur utilisateur;
	private Categorie categorie;
	private List<Enchere> listeEncheres = new ArrayList<>();
	private String etatVente;
	private Retrait retrait;
	
	public ArticleVendu() {
	}
	
	

	public ArticleVendu(Integer noArticle, String nomArticle, String description, LocalDate dateDebutEncheres,
			LocalDate dateFinEncheres, Integer prixInitial, Integer prixVente, String etatVente) {
		super();
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.prixInitial = prixInitial;
		this.prixVente = prixVente;
		this.etatVente = etatVente;
	}

	public ArticleVendu(String nomArticle, String description, LocalDate dateDebutEncheres, LocalDate dateFinEncheres,
			Integer prixInitial, Integer prixVente, Utilisateur utilisateur, Categorie categorie,
			List<Enchere> listeEncheres, String etatVente) {
		super();
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.prixInitial = prixInitial;
		this.prixVente = prixVente;
		this.utilisateur = utilisateur;
		this.categorie = categorie;
		this.listeEncheres = listeEncheres;
		this.etatVente = etatVente;
	}
	
	
	
	public ArticleVendu(String nomArticle, String description, LocalDate dateDebutEncheres, LocalDate dateFinEncheres,
			Integer prixInitial, Utilisateur utilisateur, Categorie categorie, String etatVente) {
		super();
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.prixInitial = prixInitial;
		this.utilisateur = utilisateur;
		this.categorie = categorie;
		this.etatVente = etatVente;
	}
	
	

	public ArticleVendu(String nomArticle, String description, LocalDate dateDebutEncheres, LocalDate dateFinEncheres,
			Integer prixInitial, Integer prixVente, Utilisateur utilisateur, Categorie categorie,
			Retrait retrait) {
		super();
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.prixInitial = prixInitial;
		this.prixVente = prixVente;
		this.utilisateur = utilisateur;
		this.categorie = categorie;
		this.etatVente = etatVente;
		this.retrait = retrait;
	}



	public Integer getNoArticle() {
		return noArticle;
	}


	public void setNoArticle(Integer noArticle) {
		this.noArticle = noArticle;
	}


	public String getNomArticle() {
		return nomArticle;
	}


	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public LocalDate getDateDebutEncheres() {
		return dateDebutEncheres;
	}


	public void setDateDebutEncheres(LocalDate dateDebutEncheres) {
		this.dateDebutEncheres = dateDebutEncheres;
	}


	public LocalDate getDateFinEncheres() {
		return dateFinEncheres;
	}


	public void setDateFinEncheres(LocalDate dateFinEncheres) {
		this.dateFinEncheres = dateFinEncheres;
	}


	public Integer getPrixInitial() {
		return prixInitial;
	}


	public void setPrixInitial(Integer prixInitial) {
		this.prixInitial = prixInitial;
	}


	public Integer getPrixVente() {
		return prixVente;
	}


	public void setPrixVente(Integer prixVente) {
		this.prixVente = prixVente;
	}


	public Utilisateur getUtilisateur() {
		return utilisateur;
	}


	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}


	public Categorie getCategorie() {
		return categorie;
	}


	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}


	public List<Enchere> getListeEncheres() {
		return listeEncheres;
	}


	public void setListeEncheres(List<Enchere> listeEncheres) {
		this.listeEncheres = listeEncheres;
	}


	public String getEtatVente() {
		return etatVente;
	}


	public void setEtatVente(String etatVente) {
		this.etatVente = etatVente;
	}


	public Retrait getRetrait() {
		return retrait;
	}


	public void setRetrait(Retrait retrait) {
		this.retrait = retrait;
	}


	@Override
	public String toString() {
		return "ArticleVendu [noArticle=" + noArticle + ", nomArticle=" + nomArticle + ", description=" + description
				+ ", dateDebutEncheres=" + dateDebutEncheres + ", dateFinEncheres=" + dateFinEncheres + ", prixInitial="
				+ prixInitial + ", prixVente=" + prixVente;/* + ", utilisateur=" + utilisateur + ", categorie=" + categorie
				+ ", encheres=" + listeEncheres + ", etatVente=" + etatVente + ", retrait=" + retrait + "]";*/
	}
	
	public void addUtilisateur(Utilisateur u) {
		u.addArticle(this);
	}
	
	public void addEnchere(Enchere e) {
		listeEncheres.add(e);
		e.setArticleVendu(this);
	}
	
	public void addCategorie(Categorie c) {
		setCategorie(c);
	}
	
	public void addRetrait(Retrait r) {
		setRetrait(r);
	}

}
