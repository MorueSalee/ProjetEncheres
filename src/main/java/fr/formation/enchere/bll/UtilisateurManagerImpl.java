package fr.formation.enchere.bll;


import fr.formation.enchere.bll.exception.BusinessException;
import fr.formation.enchere.bo.Utilisateur;
import fr.formation.enchere.dal.DALException;
import fr.formation.enchere.dal.UtilisateurDAO;
import fr.formation.enchere.dal.UtilisateurDAOFact;

public class UtilisateurManagerImpl implements UtilisateurManager {

private UtilisateurDAO dao = UtilisateurDAOFact.getUtilisateurDAO();
	
	public void addUtilisateur(Utilisateur utilisateur) throws DALException, IllegalArgumentException {
	    try {
	        if (!isPseudoUnique(utilisateur.getPseudo())) {
	            throw new IllegalArgumentException("Le pseudo est déjà utilisé.");
	        } else if (!isEmailUnique(utilisateur.getEmail())) {
	            throw new IllegalArgumentException("L'email est déjà utilisé.");
	        } else if (!isPhoneNumberValid(utilisateur.getTelephone())) {
	            throw new IllegalArgumentException("Le numéro de téléphone n'est pas valide.");
	        } else if (!isPostalCodeValid(utilisateur.getCodePostal())) {
	            throw new IllegalArgumentException("Le code postal n'est pas valide.");
	        } else if (!isAlphaNumeric(utilisateur.getPseudo())) {
	            throw new IllegalArgumentException("Le pseudo ne doit contenir que des caractères alphanumériques.");
	        } else {
	            dao.insert(utilisateur);
	        }
	    } catch (BusinessException e) {
	        e.printStackTrace();
	    } catch (DALException e) {
	        e.printStackTrace();
	    }    
	}
	
	public Utilisateur check(String identifiant, String motDePasse) throws BusinessException, DALException {
		return dao.findByLoginAndPassword(identifiant, motDePasse);
	}
	
	private boolean isPseudoUnique(String pseudo) throws BusinessException, DALException {
		if (dao.findByPseudo(pseudo) == null) {
			return true;
		}
		
	    return false;
	}
	
	private boolean isEmailUnique(String email) throws BusinessException, DALException {
	    if (!isValidEmail(email)) {
	        throw new IllegalArgumentException("L'adresse e-mail n'est pas valide.");
	    }

	    if (dao.findByEmail(email) == null) {
	        return true;
	    }

	    return false;
	}

	private boolean isValidEmail(String email) {
	    String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
	    return email.matches(emailRegex);
	}
	
	private boolean isPhoneNumberValid(String phoneNumber) {
		return phoneNumber.matches("^(\\+33|06)\\d{8}$");
	}
	
	private boolean isPostalCodeValid(String postalCode) {
	    return postalCode.matches("^(\\d{5}|2[0-9]{3})$");
	}
	
	private boolean isAlphaNumeric(String str) {
	    return str.matches("^[a-zA-Z0-9_-]+$");
	}
	
	public Utilisateur findById(Integer id) throws DALException {
		Utilisateur utilisateur = null;
		utilisateur = dao.findById(id);
		
	    return utilisateur;
	}
	
	public void update(Utilisateur utilisateur) throws DALException {
		try {
			if (!isPostalCodeValid(utilisateur.getCodePostal())) {
			    throw new IllegalArgumentException("Le code postal n'est pas valide.");
			} else if (!isAlphaNumeric(utilisateur.getPseudo())) {
			    throw new IllegalArgumentException("Le pseudo ne doit contenir que des caractères alphanumériques.");
			} else {
				dao.update(utilisateur);			
			}
		} catch (DALException e) {
			e.printStackTrace();
		}
	}
	
	public void delete(Integer id) throws DALException {
		dao.delete(id);
	}
		
}
