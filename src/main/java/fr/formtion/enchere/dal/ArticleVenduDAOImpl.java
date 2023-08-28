package fr.formtion.enchere.dal;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fr.formtion.enchere.bo.ArticleVendu;

public class ArticleVenduDAOImpl implements ArticleVenduDAO {

	final String SELECT_ALL = "SELECT * FROM ARTICLES_VENDUS;";
    final String INSERT = "INSERT INTO ARTICLES_VENDUS(" +
            "nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie) " +
            "VALUES(?, ?, ?, ?, ?, ?, ?, ?);";
    final String UPDATE = "UPDATE ARTICLES_VENDUS SET nom_article = ?, description = ?, date_debut_encheres = ?, date_fin_encheres = ?, " +
            "prix_initial = ?, prix_vente = ?, no_utilisateur = ?, no_categorie = ? WHERE no_article = ?";

    private ArticleVendu getResult(ResultSet rs) throws SQLException {
        Integer noArticle = rs.getInt("no_article");
        String nomArticle = rs.getString("nom_article");
        String description = rs.getString("description");
        LocalDate dateDebutEncheres = rs.getDate("date_debut_encheres").toLocalDate();
        LocalDate dateFinEncheres = rs.getDate("date_fin_encheres").toLocalDate();
        Integer prixInitial = rs.getInt("prix_initial");
        Integer prixVente = rs.getInt("prix_vente");
        Integer noUtilisateur = rs.getInt("no_utilisateur");
        Integer noCategorie = rs.getInt("no_categorie");

        ArticleVendu a = new ArticleVendu(noArticle, nomArticle, description, dateDebutEncheres, dateFinEncheres, prixInitial, prixVente, noUtilisateur, noCategorie);
        
        return a;
    }
    
	@Override
	public void insert(ArticleVendu article) throws DALException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ArticleVendu> getAll() throws DALException {

		List<ArticleVendu> listeArticlesVendus = new ArrayList<ArticleVendu>();
		
		try (Connection cnx = JdbcTools.getConnection()) {
			Statement stmt = cnx.createStatement();
			ResultSet rs = stmt.executeQuery(SELECT_ALL);
			while (rs.next()) {
                ArticleVendu a = getResult(rs);
                listeArticlesVendus.add(a);
            }
		} catch (Exception e) {
			e.printStackTrace();
			throw new DALException(e.getMessage());
		}
		
		return listeArticlesVendus;
		
	}

	@Override
	public void update(ArticleVendu article) throws DALException {
		// TODO Auto-generated method stub
		
	}

}
