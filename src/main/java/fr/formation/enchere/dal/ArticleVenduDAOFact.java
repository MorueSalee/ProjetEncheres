package fr.formation.enchere.dal;

public class ArticleVenduDAOFact {

	public static ArticleVenduDAO getArticleVenduDAO() {
        return new ArticleVenduDAOImpl();
    }
	
}
