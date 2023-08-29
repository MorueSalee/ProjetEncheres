package fr.formation.enchere.dal;

public class UtilisateurDAOFact {
	public static UtilisateurDAO getUtilisateurDAO() {
		return new UtilisateurDAOImpl();
	}

}
