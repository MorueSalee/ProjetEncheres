package fr.formation.enchere.ihm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.apache.catalina.Manager;

import fr.formation.enchere.bll.ArticleVenduManager;
import fr.formation.enchere.bll.ArticleVenduManagerSing;
import fr.formation.enchere.bo.ArticleVendu;
import fr.formation.enchere.bo.Utilisateur;
import fr.formation.enchere.dal.DALException;

/**
 * Servlet implementation class NewSaleServlet
 */
public class NewSaleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArticleVenduManager manager = ArticleVenduManagerSing.getInstance();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewSaleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/newSale.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		// recuperation d'un utilisateur
		Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");

		String nomArticle = request.getParameter("nomArticle");
	    String description = request.getParameter("description");
	    DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate dateDebutEncheres =(LocalDate.parse(request.getParameter("dateDebutEncheres"),dtf2));
		LocalDate dateFinEncheres=(LocalDate.parse(request.getParameter("dateFinEncheres"),dtf2));
	    String prixInitial = request.getParameter("prixInitial");
		int noCategorie =Integer.parseInt(request.getParameter("categories"));
		
	    try {
			manager.add(new ArticleVendu(nomArticle, description, dateDebutEncheres, dateFinEncheres, prixInitial, noCategorie, "Debut"));
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
