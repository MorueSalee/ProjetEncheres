package fr.formation.enchere.bll;

import java.util.List;

import fr.formation.enchere.bo.ArticleVendu;
import fr.formation.enchere.dal.ArticleVenduDAO;
import fr.formation.enchere.dal.ArticleVenduDAOFact;
import fr.formation.enchere.dal.DALException;

public class ArticleVenduManagerImpl implements ArticleVenduManager {

private ArticleVenduDAO dao = ArticleVenduDAOFact.getArticleVenduDAO();
	
	public void add(ArticleVendu article) {
		try {
			dao.insert(article);
		} catch (DALException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<ArticleVendu> getAll() {
		try {
			List<ArticleVendu> result = dao.getAll();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void update(ArticleVendu article) {
		try {
			dao.update(article);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
