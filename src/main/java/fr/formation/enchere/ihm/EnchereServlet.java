package fr.formation.enchere.ihm;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import fr.formation.enchere.bll.ArticleVenduManager;
import fr.formation.enchere.bll.ArticleVenduManagerSing;
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
		
		//Bouton rechercher
		if (request.getParameter("btnRechercher") != null) {
			//Recherche par nom d'article
			if (request.getParameter("nomArticle") != null) {
				articleModel.setListArticle(articleManager.getByName(request.getParameter("nomArticle")));
			//Recherche par catégorie
			} else if (request.getParameter("categorie") != "Toutes") {
				articleModel.setListArticle(articleManager.getByCategorie(request.getParameter("nomArticle")));
			//Recherche par nom et catégorie
			} else if (request.getParameter("nomArticle") != null && request.getParameter("categorie") != null) {
				
			}		
			
			try {
				manager.addTask(task);
			} catch (TaskException e) {
				message = bundle.getString(e.getMessage());
			}
		}

		doGet(request, response);
	}

}
