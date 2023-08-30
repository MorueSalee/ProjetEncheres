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
 * Servlet implementation class ConnectionServlet
 */
public class ConnectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtilisateurManager manager = UtilisateurManagerSing.getInstance();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConnectionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/connection.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String identifiant = request.getParameter("identifiant");
	    String motDePasse = request.getParameter("motDePasse");

	    try {
	        Utilisateur utilisateur = manager.check(identifiant, motDePasse);
	        if (utilisateur == null) {
	            request.setAttribute("message", "Utilisateur inconnu");
	            request.getRequestDispatcher("/WEB-INF/connection.jsp").forward(request, response);
	            System.out.println("Utilisateur inconnu");
	        } else {
	        	// On met l'utilisateur en session
				request.getSession().setAttribute("utilisateur", utilisateur);

				// On appelle l'url de la servlet initialisement appelée
				String urlPattern = (String) request.getSession().getAttribute("urlPattern");

				// Si pas de servlet initialement appelée on va sur l'url racine (ou il y a généralement le menu
				if(urlPattern==null) {
					urlPattern="/EnchereServlet";
				}
				
				request.getRequestDispatcher(urlPattern).forward(request, response);
	        }
	    } catch (DALException e) {
	        // Gestion de l'exception
	        e.printStackTrace();
	    }
	}


}
