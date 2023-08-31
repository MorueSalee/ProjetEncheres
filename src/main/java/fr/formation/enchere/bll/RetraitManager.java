package fr.formation.enchere.bll;

import fr.formation.enchere.bo.Retrait;
import fr.formation.enchere.dal.DALException;

public interface RetraitManager {
	public void add(Integer noArticle, Retrait retrait) throws DALException;
	public void update(Retrait retrait) throws DALException;
}
