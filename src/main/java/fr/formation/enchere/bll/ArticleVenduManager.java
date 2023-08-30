package fr.formation.enchere.bll;

import java.util.List;

import fr.formation.enchere.bo.ArticleVendu;
import fr.formation.enchere.dal.DALException;

public interface ArticleVenduManager {
	public void add(ArticleVendu article) throws DALException;
	public List<ArticleVendu> getAll() throws DALException;
	public void update(ArticleVendu article) throws DALException;
}
