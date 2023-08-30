package fr.formation.enchere.dal;

public class RetraitDAOFact {
	public static RetraitDAO getRetraitDAO() {
		return new RetraitDAOImpl();
	}

}
