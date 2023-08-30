package fr.formation.enchere.dal;

import java.util.List;

import fr.formation.enchere.bo.Utilisateur;

public interface UtilisateurDAO {
	
	public void insert(Utilisateur article) throws DALException;
	public Utilisateur findById(Integer id) throws DALException;
	//public void getAll() throws DALException;
	public void delete(Integer id) throws DALException;
	public void update(Utilisateur article) throws DALException;
	public List<Utilisateur> findByLoginAndPassword(String identifiant, String motDePasse) throws DALException;
	public List<Utilisateur> findByPseudo(String pseudo) throws DALException;
	public List<Utilisateur> findByEmail(String email) throws DALException;
}
