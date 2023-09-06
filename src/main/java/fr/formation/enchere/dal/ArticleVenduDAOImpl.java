package fr.formation.enchere.dal;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fr.formation.enchere.bo.ArticleVendu;
import fr.formation.enchere.bo.Categorie;
import fr.formation.enchere.bo.Retrait;
import fr.formation.enchere.dal.util.ConnectionProvider;

public class ArticleVenduDAOImpl implements ArticleVenduDAO {

	final String SELECT_ALL = """
			SELECT * FROM ARTICLES_VENDUS
			INNER JOIN UTILISATEURS ON ARTICLES_VENDUS.no_utilisateur = UTILISATEURS.no_utilisateur
			INNER JOIN CATEGORIES ON ARTICLES_VENDUS.no_categorie = CATEGORIES.no_categorie
			INNER JOIN RETRAITS ON ARTICLES_VENDUS.no_article = RETRAITS.no_article
			LEFT JOIN ENCHERES ON ARTICLES_VENDUS.no_article = ENCHERES.no_article;
			""";
    final String INSERT = """
    		INSERT INTO ARTICLES_VENDUS
    		(nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie, etat_vente)
    		VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?);
    		""";
    final String UPDATE = """
    		UPDATE ARTICLES_VENDUS
    		SET nom_article=?, description=?, date_debut_encheres=?, date_fin_encheres=?, prix_initial=?, prix_vente=?, no_utilisateur=?, no_categorie=?, etat_vente=?
    		WHERE no_article = ?;
    		""";
    final String SELECT_BY_ID = """
    		SELECT * FROM ARTICLES_VENDUS
    		INNER JOIN UTILISATEURS ON ARTICLES_VENDUS.no_utilisateur = UTILISATEURS.no_utilisateur
    		INNER JOIN CATEGORIES ON ARTICLES_VENDUS.no_categorie = CATEGORIES.no_categorie
    		INNER JOIN RETRAITS ON ARTICLES_VENDUS.no_article = RETRAITS.no_article
			LEFT JOIN ENCHERES ON ARTICLES_VENDUS.no_article = ENCHERES.no_article
    		WHERE ARTICLES_VENDUS.no_article = ?;
    		""";
    final String SELECT_BY_NAME = """
    		SELECT * FROM ARTICLES_VENDUS
    		INNER JOIN UTILISATEURS ON ARTICLES_VENDUS.no_utilisateur = UTILISATEURS.no_utilisateur
    		INNER JOIN CATEGORIES ON ARTICLES_VENDUS.no_categorie = CATEGORIES.no_categorie
    		INNER JOIN RETRAITS ON ARTICLES_VENDUS.no_article = RETRAITS.no_article
			LEFT JOIN ENCHERES ON ARTICLES_VENDUS.no_article = ENCHERES.no_article
    		WHERE ARTICLES_VENDUS.nom_article LIKE ?;
    		""";
    final String SELECT_BY_CATEGORIE = """
    		SELECT * FROM ARTICLES_VENDUS
    		INNER JOIN UTILISATEURS ON ARTICLES_VENDUS.no_utilisateur = UTILISATEURS.no_utilisateur
    		INNER JOIN CATEGORIES ON ARTICLES_VENDUS.no_categorie = CATEGORIES.no_categorie
    		INNER JOIN RETRAITS ON ARTICLES_VENDUS.no_article = RETRAITS.no_article
			LEFT JOIN ENCHERES ON ARTICLES_VENDUS.no_article = ENCHERES.no_article
    		WHERE ARTICLES_VENDUS.no_categorie = ?;
    		""";
    final String SELECT_BY_NAME_AND_CATEGORIE = """
    		SELECT * FROM ARTICLES_VENDUS
    		INNER JOIN UTILISATEURS ON ARTICLES_VENDUS.no_utilisateur = UTILISATEURS.no_utilisateur
    		INNER JOIN CATEGORIES ON ARTICLES_VENDUS.no_categorie = CATEGORIES.no_categorie
    		INNER JOIN RETRAITS ON ARTICLES_VENDUS.no_article = RETRAITS.no_article
			LEFT JOIN ENCHERES ON ARTICLES_VENDUS.no_article = ENCHERES.no_article
    		WHERE ARTICLES_VENDUS.nom_article LIKE ? AND CATEGORIES.libelle = ?;
    		""";
    final String SELECT_BY_CATEGORIE_LIBELLE = """
    		SELECT * FROM ARTICLES_VENDUS
    		INNER JOIN UTILISATEURS ON ARTICLES_VENDUS.no_utilisateur = UTILISATEURS.no_utilisateur
    		INNER JOIN CATEGORIES ON ARTICLES_VENDUS.no_categorie = CATEGORIES.no_categorie
    		INNER JOIN RETRAITS ON ARTICLES_VENDUS.no_article = RETRAITS.no_article
			LEFT JOIN ENCHERES ON ARTICLES_VENDUS.no_article = ENCHERES.no_article
    		WHERE CATEGORIES.libelle = ?;
    		""";
    
    public static ArticleVendu getArticle(ResultSet rs) throws SQLException {
    	Integer noArticle = rs.getInt("no_article");
        String nomArticle = rs.getString("nom_article");
        String description = rs.getString("description");
        LocalDate dateDebutEncheres = rs.getDate("date_debut_encheres").toLocalDate();
        LocalDate dateFinEncheres = rs.getDate("date_fin_encheres").toLocalDate();
        Integer prixInitial = rs.getInt("prix_initial");
        Integer prixVente = rs.getInt("prix_vente");
        String etatVente = rs.getString("etat_vente");

        ArticleVendu a = new ArticleVendu(noArticle, nomArticle, description, dateDebutEncheres, dateFinEncheres, prixInitial, prixVente, etatVente);
        
        return a;
    }
    
	@Override
	public void insert(ArticleVendu article) throws DALException {
	    try (Connection con = ConnectionProvider.getConnection()) {
	        PreparedStatement stmt = con.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
	        stmt.setString(1, article.getNomArticle());
	        stmt.setString(2, article.getDescription());
	        stmt.setDate(3, java.sql.Date.valueOf(article.getDateDebutEncheres()));
	        stmt.setDate(4, java.sql.Date.valueOf(article.getDateFinEncheres()));
	        stmt.setInt(5, article.getPrixInitial());
	        stmt.setInt(6, article.getPrixVente());
	        stmt.setInt(7, article.getUtilisateur().getNoUtilisateur());
	        stmt.setInt(8, article.getCategorie().getNoCategorie());
	        stmt.setString(9, article.getEtatVente());

	        int affectedRows = stmt.executeUpdate();
	        if (affectedRows == 0) {
	            throw new SQLException("L'insertion a échoué, aucune ligne affectée.");
	        }

	        try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
	            if (generatedKeys.next()) {
	                article.setNoArticle(generatedKeys.getInt(1));

	                Retrait retrait = new Retrait();
	               
	                retrait.setRue(article.getRetrait().getRue());
	                retrait.setVille(article.getRetrait().getVille());
	                retrait.setCodePostal(article.getRetrait().getCodePostal());

	                RetraitDAOFact.getRetraitDAO().insert(article.getNoArticle(), retrait);
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        throw new DALException(e.getMessage());
	    }
	}


	@Override
	public List<ArticleVendu> getAll() throws DALException {
		List<ArticleVendu> results = new ArrayList<>();
		ArticleVendu article = null;
		
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(SELECT_ALL);
			ResultSet rs = stmt.executeQuery();

			while(rs.next()) {
				if (getArticle(rs) != null) {
					if (results.size() != 0 && rs.getInt("no_article") != results.get(results.size()-1).getNoArticle()) {
						article = null;
					}
					if (article == null) {
						article = getArticle(rs);
						article.setNoArticle(rs.getInt("no_article"));
						results.add(article);
					}
					if (rs.getInt("no_enchere") != 0) {
						results.get(results.size() - 1).addEnchere(EnchereDAOImpl.getEnchere(rs));
					}
					results.get(results.size() - 1).addUtilisateur(UtilisateurDAOImpl.getUtilisateur(rs));
					results.get(results.size() - 1).addCategorie(CategorieDAOImpl.getCategorie(rs));
					results.get(results.size() - 1).addRetrait(RetraitDAOImpl.getRetrait(rs));

				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DALException(e.getMessage());
		}
		
		return results;
		
	}
	

	@Override
	public void update(ArticleVendu article) throws DALException {
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pStmt = cnx.prepareStatement(UPDATE, PreparedStatement.RETURN_GENERATED_KEYS);
			pStmt.setString(1, article.getNomArticle());
			pStmt.setString(2, article.getDescription());
			pStmt.setDate(3, java.sql.Date.valueOf(article.getDateDebutEncheres()));
			pStmt.setDate(4, java.sql.Date.valueOf(article.getDateFinEncheres()));
			pStmt.setInt(5, article.getPrixInitial());
			pStmt.setInt(6, article.getPrixVente());
			pStmt.setInt(7, article.getUtilisateur().getNoUtilisateur());
			pStmt.setInt(8, article.getCategorie().getNoCategorie());
			pStmt.setString(9, article.getEtatVente());
			pStmt.setInt(10, article.getNoArticle());
			
	        pStmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	        throw new DALException((e.getMessage()));
	    }
		
	}

	@Override
	public ArticleVendu getById(Integer id) throws DALException {		
		ArticleVendu article = null;
		
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(SELECT_BY_ID);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				if (getArticle(rs) != null) {
					if (article == null) {
						article = getArticle(rs);
						article.setNoArticle(rs.getInt("no_article"));
					}
					if (rs.getInt("no_enchere") != 0) {
						article.addEnchere(EnchereDAOImpl.getEnchere(rs));
					}
					article.addUtilisateur(UtilisateurDAOImpl.getUtilisateur(rs));
					article.addCategorie(CategorieDAOImpl.getCategorie(rs));
					article.addRetrait(RetraitDAOImpl.getRetrait(rs));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DALException(e.getMessage());
		}
		
		return article;
	}

	@Override
	public List<ArticleVendu> getByName(String name) throws DALException {
		List<ArticleVendu> results = new ArrayList<ArticleVendu>();
		ArticleVendu article = null;
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(SELECT_BY_NAME);
			stmt.setString(1, "%" + name + "%");
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				if (getArticle(rs) != null) {
					if (results.size() != 0 && rs.getInt("no_article") != results.get(results.size()-1).getNoArticle()) {
						article = null;
					}
					if (article == null) {
						article = getArticle(rs);
						article.setNoArticle(rs.getInt("no_article"));
						results.add(article);
					}
					if (rs.getInt("no_enchere") != 0) {
						results.get(results.size() - 1).addEnchere(EnchereDAOImpl.getEnchere(rs));
					}
					
					results.get(results.size() - 1).addUtilisateur(UtilisateurDAOImpl.getUtilisateur(rs));
					results.get(results.size() - 1).addCategorie(CategorieDAOImpl.getCategorie(rs));
					results.get(results.size() - 1).addRetrait(RetraitDAOImpl.getRetrait(rs));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DALException(e.getMessage());
		}
		
		return results;
	}

	@Override
	public List<ArticleVendu> getByCategorie(Categorie categorie) throws DALException {
		List<ArticleVendu> results = new ArrayList<ArticleVendu>();
		ArticleVendu article = null;
		
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(SELECT_BY_CATEGORIE);
			stmt.setInt(1, categorie.getNoCategorie());
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				if (getArticle(rs) != null) {
					if (results.size() != 0 && rs.getInt("no_article") != results.get(results.size()-1).getNoArticle()) {
						article = null;
					}
					if (article == null) {
						article = getArticle(rs);
						article.setNoArticle(rs.getInt("no_article"));
						results.add(article);
					}
					if (rs.getInt("no_enchere") != 0) {
						results.get(results.size() - 1).addEnchere(EnchereDAOImpl.getEnchere(rs));
					}
					results.get(results.size() - 1).addUtilisateur(UtilisateurDAOImpl.getUtilisateur(rs));
					results.get(results.size() - 1).addCategorie(CategorieDAOImpl.getCategorie(rs));
					results.get(results.size() - 1).addRetrait(RetraitDAOImpl.getRetrait(rs));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DALException(e.getMessage());
		}
		
		return results;
	}

	@Override
	public List<ArticleVendu> getByNameAndCategorie(String name, String libelle) throws DALException {
		List<ArticleVendu> results = new ArrayList<ArticleVendu>();
		ArticleVendu article = null;
		
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(SELECT_BY_NAME_AND_CATEGORIE);
			stmt.setString(1, "%" + name + "%");
			stmt.setString(2, libelle);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				if (getArticle(rs) != null) {
					if (results.size() != 0 && rs.getInt("no_article") != results.get(results.size()-1).getNoArticle()) {
						article = null;
					}
					if (article == null) {
						article = getArticle(rs);
						article.setNoArticle(rs.getInt("no_article"));
						results.add(article);
					}
					if (rs.getInt("no_enchere") != 0) {
						results.get(results.size() - 1).addEnchere(EnchereDAOImpl.getEnchere(rs));
					}
					results.get(results.size() - 1).addUtilisateur(UtilisateurDAOImpl.getUtilisateur(rs));
					results.get(results.size() - 1).addCategorie(CategorieDAOImpl.getCategorie(rs));
					results.get(results.size() - 1).addRetrait(RetraitDAOImpl.getRetrait(rs));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DALException(e.getMessage());
		}
		
		return results;
	}
	
	@Override
	public List<ArticleVendu> getByCategorieLibelle(String libelle) throws DALException {
		List<ArticleVendu> results = new ArrayList<ArticleVendu>();
		ArticleVendu article = null;
		
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(SELECT_BY_CATEGORIE_LIBELLE);
			stmt.setString(1, libelle);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				if (getArticle(rs) != null) {
					if (results.size() != 0 && rs.getInt("no_article") != results.get(results.size()-1).getNoArticle()) {
						article = null;
					}
					if (article == null) {
						article = getArticle(rs);
						article.setNoArticle(rs.getInt("no_article"));
						results.add(article);
					}
					if (rs.getInt("no_enchere") != 0) {
						results.get(results.size() - 1).addEnchere(EnchereDAOImpl.getEnchere(rs));
					}
					results.get(results.size() - 1).addUtilisateur(UtilisateurDAOImpl.getUtilisateur(rs));
					results.get(results.size() - 1).addCategorie(CategorieDAOImpl.getCategorie(rs));
					results.get(results.size() - 1).addRetrait(RetraitDAOImpl.getRetrait(rs));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DALException(e.getMessage());
		}
		
		return results;
	}

}
