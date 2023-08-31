package fr.formation.enchere.dal;

import java.util.List;

import fr.formation.enchere.bo.ArticleVendu;
import fr.formation.enchere.bo.Categorie;

public interface ArticleVenduDAO {
	
	public void insert(ArticleVendu article) throws DALException;
	public ArticleVendu getById(Integer id) throws DALException;
	public List<ArticleVendu> getAll() throws DALException;
	//public void delete(Integer id) throws DALException;
	public void update(ArticleVendu article) throws DALException;
	public List<ArticleVendu> getByName(String name) throws DALException;
	public List<ArticleVendu> getByCategorie(Categorie categorie) throws DALException;
	public List<ArticleVendu> getByNameAndCategorie(String name, Categorie categorie) throws DALException;
}
