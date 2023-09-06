package fr.formation.enchere.bll;


import fr.formation.enchere.bll.exception.BusinessException;
import fr.formation.enchere.bo.Utilisateur;
import fr.formation.enchere.dal.DALException;

public interface UtilisateurManager {
	public void addUtilisateur(Utilisateur utilisateur) throws DALException, IllegalArgumentException;
	public Utilisateur check(String identifiant, String password) throws BusinessException, DALException;
	public Utilisateur findById(Integer id) throws DALException;
	public void update(Utilisateur utilisateur) throws DALException;
	public void delete(Integer id) throws DALException;
}
