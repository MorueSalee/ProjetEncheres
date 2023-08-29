package fr.formation.enchere.dal;

public class ArticleVenduDAOFactory {

	public static ArticleVenduDAO getArticleVenduDAO() {
        return new ArticleVenduDAOImpl();
    }
	
}
