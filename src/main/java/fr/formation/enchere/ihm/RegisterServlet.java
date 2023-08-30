package fr.formation.enchere.ihm;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import fr.formation.enchere.bll.UtilisateurManager;
import fr.formation.enchere.bll.UtilisateurManagerSing;
import fr.formation.enchere.bo.Utilisateur;
import fr.formation.enchere.dal.DALException;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtilisateurManager manager = UtilisateurManagerSing.getInstance();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String pseudo = request.getParameter("pseudo");
	    String motDePasse = request.getParameter("motDePasse");
	    String motDePasse2 = request.getParameter("motDePasse2");
	    String nom = request.getParameter("nom");
	    String prenom = request.getParameter("prenom");
	    String email = request.getParameter("email");
	    String telephone = request.getParameter("telephone");
	    String rue = request.getParameter("rue");
	    String codePostal = request.getParameter("codePostal");
	    String ville = request.getParameter("ville");

	    if (pseudo == null || pseudo.isBlank() || motDePasse == null || motDePasse.isBlank() || motDePasse2 == null || motDePasse2.isBlank()) {
	        request.setAttribute("message", "Le pseudo et les mots de passe doivent être remplis");
	        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
	    } else if (!motDePasse.equals(motDePasse2)) {
	        request.setAttribute("message", "Les deux mots de passe doivent être les mêmes");
	        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
	    } else {
	        try {
	            manager.addUtilisateur(new Utilisateur(pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse, 0, false));
	            request.setAttribute("message", "Inscription OK");
	            request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
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
