package fr.formation.enchere.bll;

import fr.formation.enchere.bo.Enchere;
import fr.formation.enchere.dal.DALException;
import fr.formation.enchere.dal.EnchereDAO;
import fr.formation.enchere.dal.EnchereDAOFact;

public class EnchereManagerImpl implements EnchereManager {

private EnchereDAO dao = EnchereDAOFact.getEnchereDAO();
	
	public void addEnchere(Enchere enchere) throws DALException {
		//dao.insert(enchere);
	}
}
