package fr.formation.enchere.dal;

public class EnchereDAOFact {
	public static EnchereDAO getEnchereDAO() {
		return new EnchereDAOImpl();
	}

}
