package fr.formation.enchere.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fr.formation.enchere.bo.Retrait;
import fr.formation.enchere.dal.util.ConnectionProvider;

public class RetraitDAOImpl implements RetraitDAO {
	
	final String INSERT = """
			INSERT INTO RETRAITS(no_article, rue, code_postal, ville) 
			VALUES(?, ?, ?, ?);
			""";
	final String UPDATE = """
			UPDATE RETRAITS SET rue = ?, code_postal = ?, ville = ? 
			WHERE no_article=?;
			""";
	
	public static Retrait getRetrait(ResultSet rs) throws SQLException {
		String rue = rs.getString("rue");
		String codePostal = rs.getString("code_postal");
		String ville = rs.getString("ville");
		
		Retrait r = new Retrait(rue, codePostal, ville); 
		
		return r;
	}

	@Override
	public void insert(Integer noArticle, Retrait retrait) throws DALException {
		try (Connection con = ConnectionProvider.getConnection()){
			PreparedStatement stmt = con.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, noArticle);
			stmt.setString(2, retrait.getRue());
			stmt.setString(3, retrait.getCodePostal());
			stmt.setString(4, retrait.getVille());

			stmt.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
			throw new DALException(e.getMessage());
		}
	}

	@Override
	public void update(Retrait retrait) throws DALException {
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = cnx.prepareStatement(UPDATE, PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setString(1, retrait.getRue());
			stmt.setString(2, retrait.getCodePostal());
			stmt.setString(3, retrait.getVille());
			
	        stmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	        throw new DALException((e.getMessage()));
	    }
	}

}
