package fr.formation.enchere.dal;

import fr.formation.enchere.bo.Categorie;

public interface CategorieDAO {
	
	public void insert(Categorie categorie) throws DALException;
	public Categorie getById(Integer id) throws DALException;
	public Categorie getByName(String libelle) throws DALException;
	
}
