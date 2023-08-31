package fr.formation.enchere.dal;

import fr.formation.enchere.bo.Enchere;

public interface EnchereDAO {
	
	public void insert(Enchere enchere) throws DALException;
	public void update(Enchere enchere) throws DALException;

}
