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

/**
 * Servlet implementation class ProfileServlet
 */
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtilisateurManager manager = UtilisateurManagerSing.getInstance();

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session = request.getSession();
	
			Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
			
			request.setAttribute("lstArticleByUtilisateur", utilisateur.getListeArticles());

			request.setAttribute("utilisateur", utilisateur);
	
			// envoi a la page monProfil.jsp			
			request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
