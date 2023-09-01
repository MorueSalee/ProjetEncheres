package fr.formation.enchere.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.naming.java.javaURLContextFactory;

import fr.formation.enchere.bo.ArticleVendu;
import fr.formation.enchere.bo.Categorie;
import fr.formation.enchere.bo.Enchere;
import fr.formation.enchere.bo.Utilisateur;
import fr.formation.enchere.dal.util.ConnectionProvider;

public class UtilisateurDAOImpl implements UtilisateurDAO {

	final String SELECT_BY_ID = "SELECT * FROM UTILISATEURS INNER JOIN ARTICLES_VENDUS ON UTILISATEURS.no_utilisateur = ARTICLES_VENDUS.no_utilisateur INNER JOIN ENCHERES ON UTILISATEURS.no_utilisateur = ENCHERES.no_utilisateur WHERE no_utilisateur=?;";
	final String SELECT_BY_LOGIN_AND_PASSWORD = "SELECT * FROM UTILISATEURS INNER JOIN ARTICLES_VENDUS ON UTILISATEURS.no_utilisateur = ARTICLES_VENDUS.no_utilisateur INNER JOIN ENCHERES ON UTILISATEURS.no_utilisateur = ENCHERES.no_utilisateur WHERE (pseudo = ? OR email = ?) AND mot_de_passe = ?;";
	final String SELECT_BY_PSEUDO = "SELECT * FROM UTILISATEURS INNER JOIN ARTICLES_VENDUS ON UTILISATEURS.no_utilisateur = ARTICLES_VENDUS.no_utilisateur INNER JOIN ENCHERES ON UTILISATEURS.no_utilisateur = ENCHERES.no_utilisateur WHERE pseudo=?;";
	final String SELECT_BY_EMAIL = "SELECT * FROM UTILISATEURS INNER JOIN ARTICLES_VENDUS ON UTILISATEURS.no_utilisateur = ARTICLES_VENDUS.no_utilisateur INNER JOIN ENCHERES ON UTILISATEURS.no_utilisateur = ENCHERES.no_utilisateur WHERE email=?;";
    final String INSERT = "INSERT INTO UTILISATEURS(" +
            "pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) " +
            "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    final String UPDATE = "UPDATE UTILISATEURS SET pseudo = ?, nom = ?, prenom = ?, email = ?, " +
            "telephone = ?, rue = ?, code_postal = ?, ville = ?, mot_de_passe=?, credit=?, administrateur=? WHERE no_utilisateur=?";

    final String DELETE = "DELETE FROM UTILISATEURS WHERE no_utilisateur = ?";
    
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
    
    private Enchere getEnchere(ResultSet rs) throws SQLException {
    	Integer noEnchere = rs.getInt("no_enchere");
    	LocalDate dateEnchere = rs.getDate("date_enchere").toLocalDate();
    	Integer montantEnchere = rs.getInt("montant_enchere");
    	
    	Enchere enchere = new Enchere(noEnchere, dateEnchere, montantEnchere);
    	return enchere;
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
        String motDePasse = rs.getString("mot_de_passe");
        Integer credit = rs.getInt("credit");
        Boolean administrateur = rs.getBoolean("administrateur");
        
        List<ArticleVendu> lstArticlesVendus = getArticle(rs);
        List<ArticleVendu> lstArticlesAchetes = getArticle(rs);
        List<Enchere> lstEncheres = getEnchere(rs);
         
        Utilisateur u = new Utilisateur(noUtilisateur, pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse, credit, administrateur, lstArticlesVendus, lstArticlesAchetes, lstEncheres );
       
        
        
       
        
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
			stmt.setInt(12, utilisateur.getNoUtilisateur());
			
	        stmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	        throw new DALException((e.getMessage()));
	    }
		
	}

	@Override
	public List<Utilisateur> findByLoginAndPassword(String identifiant, String motDePasse) throws DALException {
		List<Utilisateur> results = new ArrayList<Utilisateur>();
		
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(SELECT_BY_LOGIN_AND_PASSWORD);
			stmt.setString(1, identifiant);
			stmt.setString(2, identifiant);
			stmt.setString(3, motDePasse);
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
