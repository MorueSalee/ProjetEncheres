package fr.formation.enchere.bll;

import fr.formation.enchere.bo.ArticleVendu;
import fr.formation.enchere.dal.ArticleVenduDAO;
import fr.formation.enchere.dal.ArticleVenduDAOFact;
import fr.formation.enchere.dal.DALException;

public class ArticleVenduManagerImpl implements ArticleVenduManager {

private ArticleVenduDAO dao = ArticleVenduDAOFact.getArticleVenduDAO();
	
	public void addArticle(ArticleVendu articleVendu) throws DALException {
		dao.insert(articleVendu);
	}
}
