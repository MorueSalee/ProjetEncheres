package fr.formtion.enchere.dal;

import fr.formtion.enchere.bo.Utilisateur;

public interface UtilisateurDAO {
	
	public void insert(Utilisateur article) throws DALException;
	public void getById(Integer id) throws DALException;
	//public void getAll() throws DALException;
	public void delete(Integer id) throws DALException;
	public void update(Utilisateur article) throws DALException;

}
