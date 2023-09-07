package fr.formation.enchere.bll;

import fr.formation.enchere.bo.Retrait;
import fr.formation.enchere.dal.DALException;
import fr.formation.enchere.dal.RetraitDAO;
import fr.formation.enchere.dal.RetraitDAOFact;

public class RetraitManagerImpl implements RetraitManager {

private RetraitDAO dao = RetraitDAOFact.getRetraitDAO();

	@Override
	public void add(Integer noArticle, Retrait retrait) throws DALException {
		try {
			if (!isCodePostalValid(retrait.getCodePostal())) {
				throw new IllegalArgumentException("Le code postal n'est pas valide !");
			} else {
				dao.insert(noArticle, retrait);
			}
		} catch (DALException e) {
	        e.printStackTrace();
		}
		
	}

	private boolean isCodePostalValid(String postalCode) {
	    return postalCode.matches("^(\\d{5}|2[0-9]{3})$");
	}

	@Override
	public void update(Retrait retrait) throws DALException {
		dao.update(retrait);
	}
}
