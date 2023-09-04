package fr.formation.enchere.bll;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import fr.formation.enchere.bo.ArticleVendu;
import fr.formation.enchere.bo.Categorie;
import fr.formation.enchere.bo.Utilisateur;
import fr.formation.enchere.dal.ArticleVenduDAO;
import fr.formation.enchere.dal.ArticleVenduDAOFact;
import fr.formation.enchere.dal.DALException;

public class ArticleVenduManagerImpl implements ArticleVenduManager {

private ArticleVenduDAO dao = ArticleVenduDAOFact.getArticleVenduDAO();
	
	public void add(ArticleVendu article) throws DALException {
			dao.insert(article);
	}

	@Override
	public List<ArticleVendu> getAll() throws DALException {
		List<ArticleVendu> result = dao.getAll();
		
		return result;
	}

	@Override
	public void update(ArticleVendu article) throws DALException {
		dao.update(article);
	}

	@Override
	public List<ArticleVendu> getByName(String name) throws DALException {
		List<ArticleVendu> result = dao.getByName(name);
		
		return result;
	}

	@Override
	public List<ArticleVendu> getByCategorie(Categorie categorie) throws DALException {
		List<ArticleVendu> result = dao.getByCategorie(categorie);
		
		return result;
	}

	@Override
	public List<ArticleVendu> getByNameAndCategorie(String name, String libelle) throws DALException {
		List<ArticleVendu> result = dao.getByNameAndCategorie(name, libelle);
		
		return result;
	}

	@Override
	public ArticleVendu getById(Integer noArticle) throws DALException {
		ArticleVendu result = dao.getById(noArticle);;
		
		return result;
	}
	
	@Override
	public List<ArticleVendu> getByCategorieLibelle(String libelle) throws DALException {
		List<ArticleVendu> result = dao.getByCategorieLibelle(libelle);
		
		return result;
	}

	@Override
	public List<ArticleVendu> searchOffline(String name, String libelle) throws DALException {
		//Recherche par nom d'article
		if (!name.equals(null) && libelle.equals("Toutes")) {
			
			return dao.getByName(name);
			
		//Recherche par catégorie
		} else if (name.equals(null) && !libelle.equals("Toutes")) {
			
			return dao.getByCategorieLibelle(libelle);
			
		//Recherche par nom et catégorie
		} else if (!name.equals(null) && !libelle.equals("Toutes")) {
			
			return dao.getByNameAndCategorie(name, libelle);
			
		} else {
			
			return dao.getAll();
			
		}
	}

	@Override
	public List<ArticleVendu> searchOnline(String name, String libelle, List<String> checkBoxFilter, Utilisateur utilisateur) throws DALException {
		
		List<ArticleVendu> result = new ArrayList<ArticleVendu>();

		//Achats/Encheres ouvertes 1
		if (checkBoxFilter.get(1) != null) {
			List<ArticleVendu> queryResult = searchOffline(name, libelle);
			
			queryResult = queryResult.stream().filter(article -> article.getEtatVente().contains("En cours")).collect(Collectors.toList());
			
			result = Stream.concat(result.stream(), queryResult.stream()).toList();
		}
		
		//Achats/mes enchères en cours 2
		if (checkBoxFilter.get(2) != null) {
			List<ArticleVendu> queryResult = searchOffline(name, libelle);
			
			queryResult = queryResult.stream().filter(article -> article.getEtatVente().contains("En cours")).collect(Collectors.toList());
			
			queryResult = queryResult.stream().filter(article -> !article.getListeEncheres().isEmpty()).collect(Collectors.toList());
			
			queryResult = queryResult.stream().filter(article -> article.getListeEncheres().get(article.getListeEncheres().size() - 1).getNoUtilisateur().equals(utilisateur.getNoUtilisateur())).collect(Collectors.toList());
			
			result = Stream.concat(result.stream(), queryResult.stream()).toList();
		}
		
		//Achats/mes enchères remportées 3
		if (checkBoxFilter.get(3) != null) {
			List<ArticleVendu> queryResult = searchOffline(name, libelle);
			
			queryResult = queryResult.stream().filter(article -> article.getEtatVente().contains("Enchères terminées") || article.getEtatVente().contains("Retrait effectué")).collect(Collectors.toList());
			
			queryResult = queryResult.stream().filter(article -> !article.getListeEncheres().isEmpty()).collect(Collectors.toList());
			
			queryResult = queryResult.stream().filter(article -> article.getListeEncheres().get(article.getListeEncheres().size() - 1).getNoUtilisateur().equals(utilisateur.getNoUtilisateur())).collect(Collectors.toList());
			
			result = Stream.concat(result.stream(), queryResult.stream()).toList();
		}
		
		//Achats/mes ventes en cours 4
		if (checkBoxFilter.get(4) != null) {
			List<ArticleVendu> queryResult = searchOffline(name, libelle);
			
			queryResult = queryResult.stream().filter(article -> article.getEtatVente().contains("En cours")).collect(Collectors.toList());
						
			queryResult = queryResult.stream().filter(article -> article.getUtilisateur().getNoUtilisateur().equals(utilisateur.getNoUtilisateur())).collect(Collectors.toList());
			
			result = Stream.concat(result.stream(), queryResult.stream()).toList();
		}
		
		//Achats/ventes non débutées 5
		if (checkBoxFilter.get(5) != null) {
			List<ArticleVendu> queryResult = searchOffline(name, libelle);
			
			queryResult = queryResult.stream().filter(article -> article.getEtatVente().contains("Créée")).collect(Collectors.toList());
						
			queryResult = queryResult.stream().filter(article -> article.getUtilisateur().getNoUtilisateur().equals(utilisateur.getNoUtilisateur())).collect(Collectors.toList());
			
			result = Stream.concat(result.stream(), queryResult.stream()).toList();
		}
		
		//Achats/ventes non débutées 6
		if (checkBoxFilter.get(6) != null) {
			List<ArticleVendu> queryResult = searchOffline(name, libelle);
			
			queryResult = queryResult.stream().filter(article -> article.getEtatVente().contains("Enchères terminées") || article.getEtatVente().contains("Retrait effectué")).collect(Collectors.toList());
						
			queryResult = queryResult.stream().filter(article -> article.getUtilisateur().getNoUtilisateur().equals(utilisateur.getNoUtilisateur())).collect(Collectors.toList());
			
			result = Stream.concat(result.stream(), queryResult.stream()).toList();
		}
		
		return result;
	}
}
