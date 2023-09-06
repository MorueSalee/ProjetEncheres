package fr.formation.enchere.bll;

import java.util.List;

import fr.formation.enchere.bo.ArticleVendu;
import fr.formation.enchere.bo.Categorie;
import fr.formation.enchere.bo.Utilisateur;
import fr.formation.enchere.dal.DALException;

public interface ArticleVenduManager {
	public void add(ArticleVendu article) throws DALException;
	public List<ArticleVendu> getAll() throws DALException;
	public void update(ArticleVendu article) throws DALException;
	public ArticleVendu getById(Integer noArticle) throws DALException;
	public List<ArticleVendu> getByName(String name) throws DALException;
	public List<ArticleVendu> getByCategorie(Categorie categorie) throws DALException;
	public List<ArticleVendu> getByNameAndCategorie(String name, String libelle) throws DALException;
	public List<ArticleVendu> getByCategorieLibelle(String libelle) throws DALException;
	public List<ArticleVendu> searchOffline(String name, String libelle) throws DALException;
	public List<ArticleVendu> searchOnline(String name, String libelle, List<String> checkBoxFilter, Utilisateur utilisateur, Integer radioFilter) throws DALException;
	public void majEtatVente(List<ArticleVendu> lstArticle) throws DALException;
}
