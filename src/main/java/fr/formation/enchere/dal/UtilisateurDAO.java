package fr.formation.enchere.dal;

import fr.formation.enchere.bo.Utilisateur;

public interface UtilisateurDAO {
	
	public void insert(Utilisateur article) throws DALException;
	public Utilisateur getById(Integer id) throws DALException;
	//public void getAll() throws DALException;
	public void delete(Integer id) throws DALException;
	public void update(Utilisateur article) throws DALException;

}
