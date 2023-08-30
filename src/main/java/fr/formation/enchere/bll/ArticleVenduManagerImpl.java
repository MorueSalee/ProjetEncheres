package fr.formation.enchere.bll;

import java.util.List;

import fr.formation.enchere.bo.ArticleVendu;
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
}
