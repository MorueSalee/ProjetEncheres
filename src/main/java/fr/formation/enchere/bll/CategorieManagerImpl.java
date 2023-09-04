package fr.formation.enchere.bll;

import java.util.List;

import fr.formation.enchere.bo.Categorie;
import fr.formation.enchere.dal.CategorieDAO;
import fr.formation.enchere.dal.CategorieDAOFact;
import fr.formation.enchere.dal.DALException;

public class CategorieManagerImpl implements CategorieManager {

private CategorieDAO dao = CategorieDAOFact.getCategorieDAO();

	@Override
	public void add(Categorie categorie) throws DALException {
		dao.insert(categorie);		
	}

	@Override
	public Categorie getById(Integer noCategorie) throws DALException {
		return dao.getById(noCategorie);
	}

	@Override
	public Categorie getByName(String libelle) throws DALException {
		return dao.getByName(libelle);
	}


	public List<Categorie> selectAllCategories() throws DALException {
		return dao.getAll();
	}
	
	
	
}
