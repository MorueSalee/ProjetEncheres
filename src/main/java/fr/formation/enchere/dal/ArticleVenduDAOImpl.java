package fr.formation.enchere.dal;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fr.formation.enchere.bo.ArticleVendu;
import fr.formation.enchere.dal.util.ConnectionProvider;

public class ArticleVenduDAOImpl implements ArticleVenduDAO {

	final String SELECT_ALL = "SELECT * FROM ARTICLES_VENDUS;";
    final String INSERT = "INSERT INTO ARTICLES_VENDUS(" +
            "nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie) " +
            "VALUES(?, ?, ?, ?, ?, ?, ?, ?);";
    final String UPDATE = "UPDATE ARTICLES_VENDUS SET nom_article = ?, description = ?, date_debut_encheres = ?, date_fin_encheres = ?, " +
            "prix_initial = ?, prix_vente = ?, no_utilisateur = ?, no_categorie = ? WHERE no_article = ?";

    private ArticleVendu getArticle(ResultSet rs) throws SQLException {
        String nomArticle = rs.getString("nom_article");
        String description = rs.getString("description");
        LocalDate dateDebutEncheres = rs.getDate("date_debut_encheres").toLocalDate();
        LocalDate dateFinEncheres = rs.getDate("date_fin_encheres").toLocalDate();
        Integer prixInitial = rs.getInt("prix_initial");
        Integer prixVente = rs.getInt("prix_vente");
        Integer noUtilisateur = rs.getInt("no_utilisateur");
        Integer noCategorie = rs.getInt("no_categorie");

        ArticleVendu a = new ArticleVendu(nomArticle, description, dateDebutEncheres, dateFinEncheres, prixInitial, prixVente, noUtilisateur, noCategorie);
        
        return a;
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
			stmt.setInt(7, article.getNoUtilisateur());
			stmt.setInt(8, article.getNoCategorie());
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
			pStmt.setInt(7, article.getNoUtilisateur());
			pStmt.setInt(8, article.getNoCategorie());
			
	        pStmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	        throw new DALException((e.getMessage()));
	    }
		
	}

}
