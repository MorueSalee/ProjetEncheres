package fr.formation.enchere.bll;

import fr.formation.enchere.bo.ArticleVendu;
import fr.formation.enchere.bo.Enchere;
import fr.formation.enchere.bo.Retrait;
import fr.formation.enchere.dal.ArticleVenduDAO;
import fr.formation.enchere.dal.ArticleVenduDAOFact;
import fr.formation.enchere.dal.DALException;
import fr.formation.enchere.dal.EnchereDAO;
import fr.formation.enchere.dal.RetraitDAO;

public class RetraitManagerImpl implements RetraitManager {

private RetraitDAO dao = RetraitDAOFact.getRetraitDAO();
	
	public void addRetrait(Retrait retrait) throws DALException {
		dao.insert(retrait);
	}
}
