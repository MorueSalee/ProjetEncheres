package fr.formtion.enchere.dal;

public class ArticleVenduDAOFactory {

	public static ArticleVenduDAO getArticleVenduDAO() {
        return new ArticleVenduDAOImpl();
    }
	
}
