package fr.formation.enchere.bll;

import fr.formation.enchere.bll.exception.BusinessException;
import fr.formation.enchere.bo.Retrait;
import fr.formation.enchere.dal.DALException;
import fr.formation.enchere.dal.RetraitDAO;
import fr.formation.enchere.dal.RetraitDAOFact;

public class RetraitManagerImpl implements RetraitManager {

private RetraitDAO dao = RetraitDAOFact.getRetraitDAO();

	@Override
	public void add(Integer noArticle, Retrait retrait) throws DALException, BusinessException {
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
	
	@Override
	public boolean isCodePostalValid(String postalCode) throws BusinessException {
	    return postalCode.matches("^(\\d{5}|2[0-9]{3})$");
	}

	@Override
	public void update(Retrait retrait) throws DALException {
		dao.update(retrait);
	}
}
