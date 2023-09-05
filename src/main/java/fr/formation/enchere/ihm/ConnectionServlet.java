package fr.formation.enchere.ihm;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import fr.formation.enchere.bll.UtilisateurManager;
import fr.formation.enchere.bll.UtilisateurManagerSing;
import fr.formation.enchere.bll.exception.BusinessException;
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
	        Utilisateur utilisateur = null; 

	        try {
	            utilisateur = manager.check(identifiant, motDePasse);
	        } catch (BusinessException e) {
	            e.printStackTrace();
	            request.setAttribute("message", "Erreur lors de la vérification de l'utilisateur");
	            request.getRequestDispatcher("/WEB-INF/connection.jsp").forward(request, response);
	            return;
	        }

	        if (utilisateur == null) {
	        	
	            request.setAttribute("message", "Utilisateur inconnu");
	            request.getRequestDispatcher("/WEB-INF/connection.jsp").forward(request, response);
	            
	        } else {
	            request.getSession().setAttribute("utilisateur", utilisateur);

	            response.sendRedirect("EnchereServlet");
	        }
	        
	    } catch (DALException e) {
	        e.printStackTrace();
	        request.setAttribute("message", "Erreur dans l'accès aux données");
	        request.getRequestDispatcher("/WEB-INF/connection.jsp").forward(request, response);
	    }
	}



}
