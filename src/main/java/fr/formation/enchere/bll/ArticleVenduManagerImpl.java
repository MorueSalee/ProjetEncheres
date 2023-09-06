package fr.formation.enchere.bll;


import java.time.LocalDate;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
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
	    LocalDate now = LocalDate.now();
	    if (article.getDateDebutEncheres().equals(now)) {
	        article.setEtatVente("En cours");
	    } else {
	        article.setEtatVente("Créée");
	    }
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
		if (name != null && libelle.equals("Toutes")) {
			
			return dao.getByName(name).stream().sorted(Comparator.comparing(ArticleVendu::getDateDebutEncheres).reversed()).collect(Collectors.toList());
			
		//Recherche par catégorie
		} else if (name == null && !libelle.equals("Toutes")) {
			
			return dao.getByCategorieLibelle(libelle).stream().sorted(Comparator.comparing(ArticleVendu::getDateDebutEncheres).reversed()).collect(Collectors.toList());
			
		//Recherche par nom et catégorie
		} else if (name != null && !libelle.equals("Toutes")) {
			
			return dao.getByNameAndCategorie(name, libelle).stream().sorted(Comparator.comparing(ArticleVendu::getDateDebutEncheres).reversed()).collect(Collectors.toList());
			
		} else {
			
			return dao.getAll().stream().sorted(Comparator.comparing(ArticleVendu::getDateDebutEncheres).reversed()).collect(Collectors.toList());
			
		}
	}

	@Override
	public List<ArticleVendu> searchOnline(String name, String libelle, List<String> checkBoxFilter, Utilisateur utilisateur, Integer radioFilter) throws DALException {
		
		List<ArticleVendu> queryResult = searchOffline(name, libelle);
		List<ArticleVendu> filteredResult = new ArrayList<ArticleVendu>();
		List<ArticleVendu> result = new ArrayList<ArticleVendu>();
		
		Boolean isFiltered = false;
		
		if (radioFilter == 1) {
			
			//Achats/Encheres ouvertes 1
			if (checkBoxFilter.get(1) != null) {

				filteredResult = queryResult.stream().filter(article -> article.getEtatVente().contains("En cours")).collect(Collectors.toList());
				
				result = Stream.concat(result.stream(), filteredResult.stream()).toList();
				
				isFiltered = true;
				
			}
			
			//Achats/mes enchères en cours 2
			if (checkBoxFilter.get(2) != null) {
				
				filteredResult = queryResult.stream().filter(article -> article.getEtatVente().contains("En cours")).collect(Collectors.toList());
				
				filteredResult = filteredResult.stream().filter(article -> !article.getListeEncheres().isEmpty()).collect(Collectors.toList());
				
				filteredResult = filteredResult.stream().filter(article -> article.getListeEncheres().get(article.getListeEncheres().size() - 1).getNoUtilisateur().equals(utilisateur.getNoUtilisateur())).collect(Collectors.toList());
				
				result = Stream.concat(result.stream(), filteredResult.stream()).toList();
				
				isFiltered = true;
				
			}
			
			//Achats/mes enchères remportées 3
			if (checkBoxFilter.get(3) != null) {
				
				filteredResult = queryResult.stream().filter(article -> article.getEtatVente().contains("Enchères terminées") || article.getEtatVente().contains("Retrait effectué")).collect(Collectors.toList());
				
				filteredResult = filteredResult.stream().filter(article -> !article.getListeEncheres().isEmpty()).collect(Collectors.toList());
				
				filteredResult = filteredResult.stream().filter(article -> article.getListeEncheres().get(article.getListeEncheres().size() - 1).getNoUtilisateur().equals(utilisateur.getNoUtilisateur())).collect(Collectors.toList());
				
				result = Stream.concat(result.stream(), filteredResult.stream()).toList();
				
				isFiltered = true;
			}
			
			if (isFiltered == false) {
				
				return queryResult.stream().sorted(Comparator.comparing(ArticleVendu::getDateDebutEncheres).reversed()).collect(Collectors.toList());
				
			}
		}
		
		if (radioFilter == 2) {
			
			//Achats/mes ventes en cours 4
			if (checkBoxFilter.get(4) != null) {
				
				filteredResult = queryResult.stream().filter(article -> article.getEtatVente().contains("En cours")).collect(Collectors.toList());
							
				filteredResult = filteredResult.stream().filter(article -> article.getUtilisateur().getNoUtilisateur().equals(utilisateur.getNoUtilisateur())).collect(Collectors.toList());
				
				result = Stream.concat(result.stream(), filteredResult.stream()).toList();
				
				isFiltered = true;
			}
			
			//Achats/ventes non débutées 5
			if (checkBoxFilter.get(5) != null) {
				
				filteredResult = queryResult.stream().filter(article -> article.getEtatVente().contains("Créée")).collect(Collectors.toList());
							
				filteredResult = filteredResult.stream().filter(article -> article.getUtilisateur().getNoUtilisateur().equals(utilisateur.getNoUtilisateur())).collect(Collectors.toList());
				
				result = Stream.concat(result.stream(), filteredResult.stream()).toList();
				
				isFiltered = true;
			}
			
			//Achats/ventes non débutées 6
			if (checkBoxFilter.get(6) != null) {
				
				filteredResult = queryResult.stream().filter(article -> article.getEtatVente().contains("Enchères terminées") || article.getEtatVente().contains("Retrait effectué")).collect(Collectors.toList());
							
				filteredResult = filteredResult.stream().filter(article -> article.getUtilisateur().getNoUtilisateur().equals(utilisateur.getNoUtilisateur())).collect(Collectors.toList());
				
				result = Stream.concat(result.stream(), filteredResult.stream()).toList();
				
				isFiltered = true;
			} 
			
			if (isFiltered == false) {
				
				filteredResult = queryResult.stream().filter(article -> article.getUtilisateur().getNoUtilisateur().equals(utilisateur.getNoUtilisateur())).collect(Collectors.toList());
				
				return filteredResult.stream().sorted(Comparator.comparing(ArticleVendu::getDateDebutEncheres).reversed()).collect(Collectors.toList());
								
			}
			
		}
	
		List<ArticleVendu> result2 = new ArrayList<ArticleVendu>(new HashSet<>(result)); 
		return result2.stream().sorted(Comparator.comparing(ArticleVendu::getDateDebutEncheres).reversed()).collect(Collectors.toList());

	}
  
	@Override
	public void majEtatVente(List<ArticleVendu> lstArticle) throws DALException {
		
		for (ArticleVendu article : lstArticle) {
			
			LocalDate dateDebut = article.getDateDebutEncheres();
			LocalDate dateFin = article.getDateFinEncheres();
			
			if (dateDebut.isAfter(LocalDate.now())) {
				article.setEtatVente("Créée");
			} else if ((dateDebut.isBefore(LocalDate.now()) || dateDebut.equals(LocalDate.now())) && (dateFin.isAfter(LocalDate.now()) || dateFin.equals(LocalDate.now()))) {
				article.setEtatVente("En Cours");
			} else if (dateFin.isBefore(LocalDate.now())) {
				article.setEtatVente("Enchères terminées");
			}
			update(article);
		}
		
	}
}
