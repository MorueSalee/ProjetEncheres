package fr.formation.enchere.dal;

public class CategorieDAOFact {
	public static CategorieDAO getCategorieDAO() {
		return new CategorieDAOImpl();
	}

}
