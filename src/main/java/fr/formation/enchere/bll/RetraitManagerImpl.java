package fr.formation.enchere.bll;

import fr.formation.enchere.bo.Retrait;
import fr.formation.enchere.dal.DALException;
import fr.formation.enchere.dal.RetraitDAO;
import fr.formation.enchere.dal.RetraitDAOFact;

public class RetraitManagerImpl implements RetraitManager {

private RetraitDAO dao = RetraitDAOFact.getRetraitDAO();

	@Override
	public void add(Integer noArticle, Retrait retrait) throws DALException {
		dao.insert(noArticle, retrait);
	}

	@Override
	public void update(Retrait retrait) throws DALException {
		dao.update(retrait);
	}
}
