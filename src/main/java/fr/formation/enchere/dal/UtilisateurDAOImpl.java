package fr.formation.enchere.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.formation.enchere.bo.Utilisateur;
import fr.formation.enchere.dal.util.ConnectionProvider;

public class UtilisateurDAOImpl implements UtilisateurDAO {

	final String SELECT_BY_ID = "SELECT * FROM UTILISATEURS WHERE no_utilisateur=?;";
	final String SELECT_BY_LOGIN_AND_PASSWORD = "SELECT * FROM UTILISATEURS WHERE pseudo=? AND mot_de_passe=?;";
	final String SELECT_BY_PSEUDO = "SELECT * FROM UTILISATEURS WHERE pseudo=?;";
	final String SELECT_BY_EMAIL = "SELECT * FROM UTILISATEURS WHERE email=?;";
    final String INSERT = "INSERT INTO UTILISATEURS(" +
            "pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) " +
            "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    final String UPDATE = "UPDATE UTILISATEURS SET pseudo = ?, nom = ?, prenom = ?, email = ?, " +
            "telephone = ?, rue = ?, code_postal = ?, ville = ?, mot_de_passe=?, credit=?, administrateur=? WHERE no_utilisateur=?";

    final String DELETE = "DELETE FROM UTILISATEURS WHERE no_utilisateur = ?";
    
    private Utilisateur getUtilisateur(ResultSet rs) throws SQLException {
        String pseudo = rs.getString("pseudo");
        String nom = rs.getString("nom");
        String prenom = rs.getString("prenom");
        String email = rs.getString("email");
        String telephone = rs.getString("telephone");
        String rue = rs.getString("rue");
        String codePostal = rs.getString("code_postal");
        String ville = rs.getString("ville");
        String motDePasse = rs.getString("mot_de_passe");
        Integer credit = rs.getInt("credit");
        Boolean administrateur = rs.getBoolean("administrateur");

        Utilisateur u = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse, credit, administrateur);
        
        return u;
    }
	
	@Override
	public void insert(Utilisateur utilisateur) throws DALException {
		try (Connection con = ConnectionProvider.getConnection()){
			PreparedStatement stmt = con.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, utilisateur.getPseudo());
			stmt.setString(2, utilisateur.getNom());
			stmt.setString(3, utilisateur.getPrenom());
			stmt.setString(4, utilisateur.getEmail());
			stmt.setString(5, utilisateur.getTelephone());
			stmt.setString(6, utilisateur.getRue());
			stmt.setString(7, utilisateur.getCodePostal());
			stmt.setString(8, utilisateur.getVille());
			stmt.setString(9, utilisateur.getMotDePasse());
			stmt.setInt(10, utilisateur.getCredit());
			stmt.setBoolean(11, utilisateur.getAdministrateur());
			int nb = stmt.executeUpdate();
			if(nb>0) {
				ResultSet rs= stmt.getGeneratedKeys();
				if(rs.next()) {
					utilisateur.setNoUtilisateur(rs.getInt(1));
				}
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
			throw new DALException(e.getMessage());
		}
		
	}

	@Override
	public Utilisateur findById(Integer id) throws DALException {

		Utilisateur utilisateur = null;
		
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(SELECT_BY_ID);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				utilisateur = getUtilisateur(rs);
				utilisateur.setNoUtilisateur(rs.getInt("no_utilisateur"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DALException(e.getMessage());
		}
		
		return utilisateur;
		
	}

	@Override
	public void delete(Integer id) throws DALException {
		try (Connection cnx = ConnectionProvider.getConnection()) {
            PreparedStatement pStmt = cnx.prepareStatement(DELETE, PreparedStatement.RETURN_GENERATED_KEYS);
            pStmt.setInt(1, id);
            pStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DALException((e.getMessage()));
        }		
	}

	@Override
	public void update(Utilisateur utilisateur) throws DALException {
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = cnx.prepareStatement(UPDATE, PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setString(1, utilisateur.getPseudo());
			stmt.setString(2, utilisateur.getNom());
			stmt.setString(3, utilisateur.getPrenom());
			stmt.setString(4, utilisateur.getEmail());
			stmt.setString(5, utilisateur.getTelephone());
			stmt.setString(6, utilisateur.getRue());
			stmt.setString(7, utilisateur.getCodePostal());
			stmt.setString(8, utilisateur.getVille());
			stmt.setString(9, utilisateur.getMotDePasse());
			stmt.setInt(10, utilisateur.getCredit());
			stmt.setBoolean(11, utilisateur.getAdministrateur());
			
	        stmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	        throw new DALException((e.getMessage()));
	    }
		
	}

	@Override
	public List<Utilisateur> findByLoginAndPassword(String pseudo, String motDePasse) throws DALException {
		List<Utilisateur> results = new ArrayList<Utilisateur>();
		
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(SELECT_BY_LOGIN_AND_PASSWORD);
			stmt.setString(1, pseudo);
			stmt.setString(2, motDePasse);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				if (getUtilisateur(rs) != null) {
                    results.add(getUtilisateur(rs));
                }
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DALException(e.getMessage());
		}
		
		return results;
	}

	@Override
	public List<Utilisateur> findByPseudo(String pseudo) throws DALException {
		List<Utilisateur> results = new ArrayList<Utilisateur>();
		
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(SELECT_BY_PSEUDO);
			stmt.setString(1, pseudo);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				if (getUtilisateur(rs) != null) {
                    results.add(getUtilisateur(rs));
                }
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DALException(e.getMessage());
		}
		
		return results;
	}

	@Override
	public List<Utilisateur> findByEmail(String email) throws DALException {
		List<Utilisateur> results = new ArrayList<Utilisateur>();
		
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(SELECT_BY_EMAIL);
			stmt.setString(1, email);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				if (getUtilisateur(rs) != null) {
                    results.add(getUtilisateur(rs));
                }
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DALException(e.getMessage());
		}
		
		return results;
	}
}
