package fr.formation.enchere.bll;

import fr.formation.enchere.bo.ArticleVendu;
import fr.formation.enchere.bo.Enchere;
import fr.formation.enchere.dal.ArticleVenduDAO;
import fr.formation.enchere.dal.ArticleVenduDAOFact;
import fr.formation.enchere.dal.DALException;
import fr.formation.enchere.dal.EnchereDAO;

public class EnchereManagerImpl implements EnchereManager {

private EnchereDAO dao = EnchereDAOFact.getArticleVenduDAO();
	
	public void addEnchere(Enchere enchere) throws DALException {
		dao.insert(enchere);
	}
}
