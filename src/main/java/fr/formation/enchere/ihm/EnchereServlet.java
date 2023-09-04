package fr.formation.enchere.ihm;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import fr.formation.enchere.bll.ArticleVenduManager;
import fr.formation.enchere.bll.ArticleVenduManagerSing;
import fr.formation.enchere.bo.Utilisateur;
import fr.formation.enchere.dal.DALException;
import fr.formation.enchere.ihm.model.ArticleVenduModel;

/**
 * Servlet implementation class EnchereServlet
 */
public class EnchereServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ArticleVenduManager articleManager = ArticleVenduManagerSing.getInstance();
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnchereServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		ArticleVenduModel articleModel = new ArticleVenduModel();
		
		//Affiche les encheres
		
			try {
				articleModel.setListArticle(articleManager.getAll());
			} catch (DALException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		request.setAttribute("articleModel", articleModel);
		
		request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArticleVenduModel articleModel = new ArticleVenduModel();
		HttpSession session = request.getSession();
		
		//Bouton rechercher
		if (request.getParameter("btnRechercher") != null) {
			
			if (session.getAttribute("utilisateur") != null) {
				
				Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
				
				try {
					
					List<String> lstCheckBoxFilter = new ArrayList<>();
					for (int i = 0; i <= 6; i++) {
						lstCheckBoxFilter.add(request.getParameter(String.valueOf(i)));						
					}
					
					articleModel.setListArticle(articleManager.searchOnline(request.getParameter("nomArticle"), request.getParameter("categorie"), lstCheckBoxFilter, utilisateur));
				
				} catch (DALException e) {
					e.printStackTrace();
				}
			} else {
				try {
					articleModel.setListArticle(articleManager.searchOffline(request.getParameter("nomArticle"), request.getParameter("categorie")));
				} catch (DALException e) {
					e.printStackTrace();
				}
			}
		}
			
		request.setAttribute("articleModel", articleModel);
		request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
		//doGet(request, response);
	}
		
}
