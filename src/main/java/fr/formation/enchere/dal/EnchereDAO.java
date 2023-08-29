package fr.formation.enchere.dal;

import fr.formation.enchere.bo.Enchere;

public interface EnchereDAO {
	
	public void insert(Enchere article) throws DALException;
	public void getById(Integer id) throws DALException;
	//public void getAll() throws DALException;
	//public void delete(Integer id) throws DALException;
	//public void update(Enchere article) throws DALException;

}
