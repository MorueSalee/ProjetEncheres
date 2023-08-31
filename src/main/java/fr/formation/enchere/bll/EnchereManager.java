package fr.formation.enchere.bll;

import fr.formation.enchere.bo.Enchere;
import fr.formation.enchere.dal.DALException;

public interface EnchereManager {
	public void add(Enchere enchere) throws DALException;
	public void update(Enchere enchere) throws DALException;
}
