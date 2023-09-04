package fr.formation.enchere.ihm;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
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
 * Servlet implementation class DeleteProfileServlet
 */
@WebServlet("/deleteProfile")
public class DeleteProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtilisateurManager manager = UtilisateurManagerSing.getInstance();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteProfileServlet() {
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
		
		try {
			manager.delete(utilisateur.getNoUtilisateur());
			RequestDispatcher rd = request.getRequestDispatcher("/logout");
			rd.forward(request, response);
            request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
		} catch (DALException e) {
			request.setAttribute("message", "Vous ne pouvez pas supprimer ce profil !");
            request.getRequestDispatcher("/WEB-INF/updateProfile.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
