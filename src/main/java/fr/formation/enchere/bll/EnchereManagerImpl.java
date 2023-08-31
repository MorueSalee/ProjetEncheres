package fr.formation.enchere.bll;

import fr.formation.enchere.bo.Enchere;
import fr.formation.enchere.dal.DALException;
import fr.formation.enchere.dal.EnchereDAO;
import fr.formation.enchere.dal.EnchereDAOFact;

public class EnchereManagerImpl implements EnchereManager {

private EnchereDAO dao = EnchereDAOFact.getEnchereDAO();

	@Override
	public void add(Enchere enchere) throws DALException {
		dao.insert(enchere);
	}
	
	@Override
	public void update(Enchere enchere) throws DALException {
		dao.update(enchere);
	}
		
}
