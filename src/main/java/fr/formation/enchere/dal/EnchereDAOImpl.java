package fr.formation.enchere.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import fr.formation.enchere.bo.Enchere;
import fr.formation.enchere.dal.util.ConnectionProvider;

public class EnchereDAOImpl implements EnchereDAO {
	
	final String INSERT = """
			INSERT INTO ENCHERES(no_utilisateur, no_article, date_enchere, montant_enchere) 
			VALUES(?, ?, ?, ?);
			""";
	final String UPDATE = """
			UPDATE ENCHERES SET date_enchere = ?, montant_enchere = ? 
			WHERE no_utilisateur=? AND no_article=?;
			""";
	
	public static Enchere getEnchere(ResultSet rs) throws SQLException {
    	Integer noEnchere = rs.getInt("no_enchere");
    	LocalDate dateEnchere = rs.getDate("date_enchere").toLocalDate();
    	Integer montantEnchere = rs.getInt("montant_enchere");
    	Integer noUtilisateur = rs.getInt("no_utilisateur");
    	
    	Enchere enchere = new Enchere(noEnchere, dateEnchere, montantEnchere, noUtilisateur);
    	return enchere;
    }
	
	@Override
	public void insert(Enchere enchere) throws DALException {
		try (Connection con = ConnectionProvider.getConnection()){
			PreparedStatement stmt = con.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, enchere.getUtilisateur().getNoUtilisateur());
			stmt.setInt(2, enchere.getArticleVendu().getNoArticle());
			stmt.setDate(3, java.sql.Date.valueOf(enchere.getDateEnchere()));
			stmt.setInt(4, enchere.getMontantEnchere());

			stmt.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
			throw new DALException(e.getMessage());
		}
	}

	@Override
	public void update(Enchere enchere) throws DALException {
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = cnx.prepareStatement(UPDATE, PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setDate(1, java.sql.Date.valueOf(enchere.getDateEnchere()));
			stmt.setInt(2, enchere.getMontantEnchere());
			stmt.setInt(3, enchere.getUtilisateur().getNoUtilisateur());
			stmt.setInt(4, enchere.getArticleVendu().getNoArticle());
			
	        stmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	        throw new DALException((e.getMessage()));
	    }
		
	}
	
}
