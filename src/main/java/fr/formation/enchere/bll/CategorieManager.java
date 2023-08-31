package fr.formation.enchere.bll;

import fr.formation.enchere.bo.Categorie;
import fr.formation.enchere.dal.DALException;

public interface CategorieManager {
	public void add(Categorie categorie) throws DALException;
	public Categorie getById(Integer noCategorie) throws DALException;
	public Categorie getByName(String libelle) throws DALException;
}
