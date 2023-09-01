package fr.formation.enchere.bll;

import fr.formation.enchere.bo.Utilisateur;
import fr.formation.enchere.dal.DALException;
import fr.formation.enchere.dal.UtilisateurDAO;
import fr.formation.enchere.dal.UtilisateurDAOFact;

public class UtilisateurManagerImpl implements UtilisateurManager {

private UtilisateurDAO dao = UtilisateurDAOFact.getUtilisateurDAO();
	
	public void addUtilisateur(Utilisateur utilisateur) throws DALException, IllegalArgumentException {
	    // Vérifier l'unicité du pseudo et de l'email avant d'ajouter l'utilisateur
	    if (!isPseudoUnique(utilisateur.getPseudo()) || !isEmailUnique(utilisateur.getEmail())) {
	        throw new IllegalArgumentException("Le pseudo ou l'email est déjà utilisé.");
	    } else {
	    	if (!utilisateur.getPseudo().matches("^[a-zA-Z0-9]+$")) {
		        throw new IllegalArgumentException("Le pseudo ne doit contenir que des caractères alphanumériques.");
		    } else {
				dao.insert(utilisateur);
		    }
		}    
	}
	
	public Utilisateur check(String identifiant, String motDePasse) throws DALException {
		return dao.findByLoginAndPassword(identifiant, motDePasse);
	}
	
	private boolean isPseudoUnique(String pseudo) throws DALException {
	    // Vérifier si le pseudo est unique dans la base de données
		if (dao.findByPseudo(pseudo) == null) {
			return true;
		}
		
	    return false;
	}
	
	private boolean isEmailUnique(String email) throws DALException {
	    // Vérifier si l'email est unique dans la base de données
	    if (dao.findByEmail(email) == null) {
			return true;
		}
		
	    return false;
	}
	
	public Utilisateur findById(Integer id) throws DALException {
		Utilisateur utilisateur = null;
		utilisateur = dao.findById(id);
		
	    return utilisateur;
	}
	
	public void update(Utilisateur utilisateur) throws DALException {
		dao.update(utilisateur);
	}
	
	public void delete(Integer id) throws DALException {
		dao.delete(id);
	}
	
	

}
