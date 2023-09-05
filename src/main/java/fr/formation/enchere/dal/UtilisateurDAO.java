package fr.formation.enchere.dal;

import fr.formation.enchere.bll.exception.BusinessException;
import fr.formation.enchere.bo.Utilisateur;

public interface UtilisateurDAO {
	
	public void insert(Utilisateur article) throws DALException;
	public Utilisateur findById(Integer id) throws DALException;
	//public void getAll() throws DALException;
	public void delete(Integer id) throws DALException;
	public void update(Utilisateur article) throws DALException;
	public Utilisateur findByLoginAndPassword(String identifiant, String motDePasse) throws DALException;
	public Utilisateur findByPseudo(String pseudo) throws DALException;
	public Utilisateur findByEmail(String email) throws DALException;
}
