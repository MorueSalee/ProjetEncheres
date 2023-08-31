package fr.formation.enchere.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fr.formation.enchere.bo.Categorie;
import fr.formation.enchere.dal.util.ConnectionProvider;

public class CategorieDAOImpl implements CategorieDAO {

	final String SELECT_BY_ID = "SELECT * FROM CATEGORIES WHERE no_categorie=?;";
	final String SELECT_BY_NAME = "SELECT * FROM CATEGORIES WHERE libelle=?;";
	final String INSERT = "INSERT INTO CATEGORIES(libelle) VALUES(?);";
	
	
	@Override
	public void insert(Categorie categorie) throws DALException {
		try (Connection con = ConnectionProvider.getConnection()){
			PreparedStatement stmt = con.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, categorie.getLibelle());
			int nb = stmt.executeUpdate();
			if(nb>0) {
				ResultSet rs= stmt.getGeneratedKeys();
				if(rs.next()) {
					categorie.setNoCategorie(rs.getInt(1));
				}
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
			throw new DALException(e.getMessage());
		}
		
	}

	@Override
	public Categorie getById(Integer id) throws DALException {

		Categorie categorie = null;
		
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(SELECT_BY_ID);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Integer noCategorie = rs.getInt("no_categorie");
				String libelle = rs.getString("libelle");
				categorie = new Categorie(noCategorie, libelle);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DALException(e.getMessage());
		}
		
		return categorie;
	}

	@Override
	public Categorie getByName(String libelle) throws DALException {
		Categorie categorie = null;
		
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(SELECT_BY_NAME);
			stmt.setString(1, libelle);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Integer noCategorie = rs.getInt("no_categorie");
				String libelleRs = rs.getString("libelle");
				
				categorie = new Categorie(noCategorie, libelleRs);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DALException(e.getMessage());
		}
		
		return categorie;
	}

}