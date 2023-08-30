package fr.formation.enchere.bll;


import fr.formation.enchere.bo.Retrait;
import fr.formation.enchere.dal.DALException;
import fr.formation.enchere.dal.RetraitDAO;
import fr.formation.enchere.dal.RetraitDAOFact;

public class RetraitManagerImpl implements RetraitManager {

private RetraitDAO dao = RetraitDAOFact.getRetraitDAO();
	
	public void addRetrait(Retrait retrait) throws DALException {
		//dao.insert(retrait);
	}
}
