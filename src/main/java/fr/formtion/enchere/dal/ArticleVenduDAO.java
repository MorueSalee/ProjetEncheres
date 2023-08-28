package fr.formtion.enchere.dal;

import java.util.List;

import fr.formtion.enchere.bo.ArticleVendu;

public interface ArticleVenduDAO {
	
	public void insert(ArticleVendu article) throws DALException;
	//public void getById(Integer id) throws DALException;
	public List<ArticleVendu> getAll() throws DALException;
	//public void delete(Integer id) throws DALException;
	public void update(ArticleVendu article) throws DALException;

}
