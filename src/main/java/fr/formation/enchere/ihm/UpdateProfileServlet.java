package fr.formation.enchere.ihm;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import fr.formation.enchere.bll.UtilisateurManager;
import fr.formation.enchere.bll.UtilisateurManagerSing;
import fr.formation.enchere.bo.Utilisateur;
import fr.formation.enchere.dal.DALException;

/**
 * Servlet implementation class UpdateProfileServlet
 */
public class UpdateProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtilisateurManager manager = UtilisateurManagerSing.getInstance();

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
		
		if (utilisateur == null) {
	        response.sendRedirect(request.getContextPath() + "/EnchereServlet");
	        return;
	    }

		request.setAttribute("utilisateur", utilisateur);

		request.getRequestDispatcher("/WEB-INF/updateProfile.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
		
		String pseudo = request.getParameter("pseudo");
	    String motDePasse = request.getParameter("motDePasseUpdate");
	    String motDePasse2 = request.getParameter("motDePasseUpdate2");
	    String nom = request.getParameter("nom");
	    String prenom = request.getParameter("prenom");
	    String email = request.getParameter("email");
	    String telephone = request.getParameter("telephone");
	    String rue = request.getParameter("rue");
	    String codePostal = request.getParameter("codePostal");
	    String ville = request.getParameter("ville");
	    
	    
	    if (pseudo == null || pseudo.isBlank() || motDePasse == null || motDePasse.isBlank() || motDePasse2 == null || motDePasse2.isBlank()) {
	        request.setAttribute("message", "Le pseudo et les mots de passe doivent être remplis");
	        request.getRequestDispatcher("/WEB-INF/updateProfile.jsp").forward(request, response);
	    } else if (!motDePasse.equals(motDePasse2)) {
	        request.setAttribute("message", "Les deux mots de passe doivent être les mêmes");
	        request.getRequestDispatcher("/WEB-INF/updateProfile.jsp").forward(request, response);
	    } else {
	        try {
	        	utilisateur.setPseudo(pseudo);
	            utilisateur.setMotDePasse(motDePasse);
	            utilisateur.setNom(nom);
	            utilisateur.setPrenom(prenom);
	            utilisateur.setEmail(email);
	            utilisateur.setTelephone(telephone);
	            utilisateur.setRue(rue);
	            utilisateur.setCodePostal(codePostal);
	            utilisateur.setVille(ville);
	            
	            manager.update(utilisateur);
	            request.setAttribute("message", "Modification ok !");
	            request.getRequestDispatcher("/WEB-INF/updateProfile.jsp").forward(request, response);
	        } catch (DALException e) {
	            request.setAttribute("message", "Le pseudo ou l'email est déjà utilisé.");
	            request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
	        } catch (IllegalArgumentException e) {
	            request.setAttribute("message", e.getMessage());
	            request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
	        }
	    }
	}

}
