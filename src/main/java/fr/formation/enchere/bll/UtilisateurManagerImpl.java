package fr.formation.enchere.bll;

import java.util.List;

import fr.formation.enchere.bo.Utilisateur;
import fr.formation.enchere.dal.UtilisateurDAO;

public class UtilisateurManagerImpl implements UtilisateurManager {

private UtilisateurDAO dao = UtilisateurDAOFact.getUserDAO();
	
	public void addUtilisateur(Utilisateur utilisateur) {
	    // Vérifier l'unicité du pseudo et de l'email avant d'ajouter l'utilisateur
	    if (!isPseudoUnique(utilisateur.getPseudo()) || !isEmailUnique(utilisateur.getEmail())) {
	        throw new IllegalArgumentException("Le pseudo ou l'email est déjà utilisé.");
	    }
	
	    // Vérifier si le pseudo ne contient que des caractères alphanumériques
	    if (!utilisateur.getPseudo().matches("^[a-zA-Z0-9]+$")) {
	        throw new IllegalArgumentException("Le pseudo ne doit contenir que des caractères alphanumériques.");
	    }
	
	    dao.insert(utilisateur);
	}
	
	public Utilisateur check(String pseudo, String motDePasse) {
	    List<Utilisateur> users = dao.findByLoginAndPassword(pseudo, motDePasse);
	    if (!users.isEmpty()) {
	        return users.get(0);
	    } else {
	        return null;
	    }
	}
	
	private boolean isPseudoUnique(String pseudo) {
	    // Vérifier si le pseudo est unique dans la base de données
	    List<Utilisateur> usersWithPseudo = dao.findByPseudo(pseudo);
	    return usersWithPseudo.isEmpty();
	}
	
	private boolean isEmailUnique(String email) {
	    // Vérifier si l'email est unique dans la base de données
	    List<Utilisateur> usersWithEmail = dao.findByEmail(email);
	    return usersWithEmail.isEmpty();
	}

}
