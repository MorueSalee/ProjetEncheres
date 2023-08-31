package fr.formation.enchere.dal;

import fr.formation.enchere.bo.Retrait;

public interface RetraitDAO {

	public void insert(Integer noArticle, Retrait retrait) throws DALException;
	public void update(Retrait retrait) throws DALException;
	
}
