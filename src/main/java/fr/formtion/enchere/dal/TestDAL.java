package fr.formtion.enchere.dal;

import java.time.LocalDate;
import java.util.List;

import fr.formtion.enchere.bo.ArticleVendu;

public class TestDAL {
	
	public static void main(String[] args) {
		
		ArticleVenduDAO articleVenduDAO = ArticleVenduDAOFactory.getArticleVenduDAO();
		
		ArticleVendu a1 = new ArticleVendu(1, "a", "a", LocalDate.of(2023, 8, 28), LocalDate.of(2023, 8, 30), 8, 8, 1, 1);
		
		try {
			List<ArticleVendu> articles = articleVenduDAO.getAll();
			System.out.println("\nSélection de tous les articles  : ");
            afficherArticles(articles);
		} catch (DALException e) {
			e.printStackTrace();
		}
	}
	
	private static void afficherArticles(List<ArticleVendu> articles) {
        StringBuffer sb = new StringBuffer();
        for (ArticleVendu art : articles) {
            sb.append(art.toString());
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

}
