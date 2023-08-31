package fr.formation.enchere.bll;

import java.util.List;

import fr.formation.enchere.bo.ArticleVendu;
import fr.formation.enchere.bo.Categorie;
import fr.formation.enchere.dal.ArticleVenduDAO;
import fr.formation.enchere.dal.ArticleVenduDAOFact;
import fr.formation.enchere.dal.DALException;

public class ArticleVenduManagerImpl implements ArticleVenduManager {

private ArticleVenduDAO dao = ArticleVenduDAOFact.getArticleVenduDAO();
	
	public void add(ArticleVendu article) throws DALException {
			dao.insert(article);
	}

	@Override
	public List<ArticleVendu> getAll() throws DALException {
		List<ArticleVendu> result = dao.getAll();
		
		return result;
	}

	@Override
	public void update(ArticleVendu article) throws DALException {
		dao.update(article);
	}

	@Override
	public List<ArticleVendu> getByName(String name) throws DALException {
		List<ArticleVendu> result = dao.getByName(name);;
		
		return result;
	}

	@Override
	public List<ArticleVendu> getByCategorie(Categorie categorie) throws DALException {
		List<ArticleVendu> result = dao.getByCategorie(categorie);;
		
		return result;
	}

	@Override
	public List<ArticleVendu> getByNameAndCategorie(String name, Categorie categorie) throws DALException {
		List<ArticleVendu> result = dao.getByNameAndCategorie(name, categorie);;
		
		return result;
	}

	@Override
	public ArticleVendu getById(Integer noArticle) throws DALException {
		ArticleVendu result = dao.getById(noArticle);;
		
		return result;
	}
}
