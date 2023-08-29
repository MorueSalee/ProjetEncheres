package fr.formation.enchere.bll;

import fr.formation.enchere.bo.ArticleVendu;
import fr.formation.enchere.bo.Categorie;
import fr.formation.enchere.dal.ArticleVenduDAO;
import fr.formation.enchere.dal.ArticleVenduDAOFact;
import fr.formation.enchere.dal.CategorieDAO;
import fr.formation.enchere.dal.DALException;

public class CategorieManagerImpl implements CategorieManager {

private CategorieDAO dao = CategorieDAOFact.getCategorieDAO();
	
	public void addCategorie(Categorie categorie) throws DALException {
		dao.insert(categorie);
	}
}
