package fr.formation.enchere.dal;

import java.util.List;

import fr.formation.enchere.bo.ArticleVendu;

public class TestDAL {
	
	public static void main(String[] args) {
		
		ArticleVenduDAO articleVenduDAO = ArticleVenduDAOFact.getArticleVenduDAO();
		
		//ArticleVendu a1 = new ArticleVendu(1, "a", "a", LocalDate.of(2023, 8, 28), LocalDate.of(2023, 8, 30), 8, 8, 1, 1);
		
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
    }

}
