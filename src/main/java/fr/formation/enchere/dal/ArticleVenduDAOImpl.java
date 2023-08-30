package fr.formation.enchere.dal;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fr.formation.enchere.bo.ArticleVendu;
import fr.formation.enchere.bo.Categorie;
import fr.formation.enchere.bo.Utilisateur;
import fr.formation.enchere.dal.util.ConnectionProvider;

public class ArticleVenduDAOImpl implements ArticleVenduDAO {

	final String SELECT_ALL = "SELECT * FROM ARTICLES_VENDUS " +
			"INNER JOIN UTILISATEURS ON ARTICLES_VENDUS.no_utilisateur = UTILISATEURS.no_utilisateur " +
			"INNER JOIN CATEGORIES ON ARTICLES_VENDUS.no_categorie = CATEGORIES.no_categorie;";
    final String INSERT = "INSERT INTO ARTICLES_VENDUS(" +
            "nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie, etat_vente) " +
            "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?);";
    final String UPDATE = "UPDATE ARTICLES_VENDUS SET nom_article = ?, description = ?, date_debut_encheres = ?, date_fin_encheres = ?, " +
            "prix_initial = ?, prix_vente = ?, no_utilisateur = ?, no_categorie = ?, etat_vente = ? WHERE no_article = ?";

    private ArticleVendu getArticle(ResultSet rs) throws SQLException {
    	Integer noArticle = rs.getInt("no_article");
        String nomArticle = rs.getString("nom_article");
        String description = rs.getString("description");
        LocalDate dateDebutEncheres = rs.getDate("date_debut_encheres").toLocalDate();
        LocalDate dateFinEncheres = rs.getDate("date_fin_encheres").toLocalDate();
        Integer prixInitial = rs.getInt("prix_initial");
        Integer prixVente = rs.getInt("prix_vente");
        Utilisateur utilisateur = getUtilisateur(rs);
        Categorie categorie = getCategorie(rs);
        String etatVente = rs.getString("etat_vente");

        ArticleVendu a = new ArticleVendu(noArticle, nomArticle, description, dateDebutEncheres, dateFinEncheres, prixInitial, prixVente, utilisateur, categorie, etatVente);
        
        return a;
    }
    
    private Utilisateur getUtilisateur(ResultSet rs) throws SQLException {
    	Integer noUtilisateur = rs.getInt("no_utilisateur");
        String pseudo = rs.getString("pseudo");
        String nom = rs.getString("nom");
        String prenom = rs.getString("prenom");
        String email = rs.getString("email");
        String telephone = rs.getString("telephone");
        String rue = rs.getString("rue");
        String codePostal = rs.getString("code_postal");
        String ville = rs.getString("ville");
        Integer credit = rs.getInt("credit");
        Boolean administrateur = rs.getBoolean("administrateur");

        Utilisateur u = new Utilisateur(noUtilisateur, pseudo, nom, prenom, email, telephone, rue, codePostal, ville, credit, administrateur);
        
        return u;
    }
    
    private Categorie getCategorie(ResultSet rs) throws SQLException {
    	Integer noCategorie = rs.getInt("no_categorie");
    	String libelle = rs.getString("libelle");
    	
    	Categorie c = new  Categorie(noCategorie, libelle); 
    	
    	return c;
    }
    
	@Override
	public void insert(ArticleVendu article) throws DALException {
		try (Connection con = ConnectionProvider.getConnection()){
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
			
			int nb = stmt.executeUpdate();
			if(nb>0) {
				ResultSet rs= stmt.getGeneratedKeys();
				if(rs.next()) {
					article.setNoArticle(rs.getInt(1));
				}
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
			throw new DALException(e.getMessage());
		}
	}

	@Override
	public List<ArticleVendu> getAll() throws DALException {

		List<ArticleVendu> results = new ArrayList<ArticleVendu>();
		
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(SELECT_ALL);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				ArticleVendu article = getArticle(rs);
				article.setNoArticle(rs.getInt("no_article"));
				results.add(article);
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

}
