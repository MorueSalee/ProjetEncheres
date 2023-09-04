package fr.formation.enchere.ihm;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import fr.formation.enchere.bll.ArticleVenduManager;
import fr.formation.enchere.bll.ArticleVenduManagerSing;
import fr.formation.enchere.bll.CategorieManager;
import fr.formation.enchere.bll.CategorieManagerSing;
import fr.formation.enchere.bo.ArticleVendu;
import fr.formation.enchere.bo.Categorie;
import fr.formation.enchere.bo.Utilisateur;
import fr.formation.enchere.dal.DALException;

/**
 * Servlet implementation class NewSaleServlet
 */
public class NewSaleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArticleVenduManager manager = ArticleVenduManagerSing.getInstance();
	private CategorieManager manager2 = CategorieManagerSing.getInstance();
       
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
		HttpSession session = request.getSession();
		Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
		
		if (utilisateur == null) {
	        response.sendRedirect(request.getContextPath() + "/EnchereServlet");
	        return;
	    }
		
		request.setAttribute("utilisateur", utilisateur);


		try {
			List<Categorie> lstCategories = manager2.selectAllCategories();
			request.setAttribute("categories", lstCategories);

		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("/WEB-INF/newSale.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ArticleVendu article = new ArticleVendu();
		
		// recuperation d'un utilisateur
		Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");

		String nomArticle = request.getParameter("nomArticle");
	    String description = request.getParameter("description");
	    DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate dateDebutEncheres =(LocalDate.parse(request.getParameter("dateDebutEncheres"),dtf2));
		LocalDate dateFinEncheres=(LocalDate.parse(request.getParameter("dateFinEncheres"),dtf2));
	    Integer prixInitial = Integer.parseInt(request.getParameter("prixInitial"));
	    Integer prixVente =    Integer.parseInt(request.getParameter("prixInitial"));
	    Integer categorieId = Integer.parseInt(request.getParameter("categorie"));
	    
	    Categorie categorie;
		try {
			categorie = manager2.getById(categorieId);
			
			article.setNomArticle(nomArticle);
		    article.setDescription(description);
		    article.setDateDebutEncheres(dateDebutEncheres);
		    article.setDateFinEncheres(dateFinEncheres);
		    article.setPrixInitial(prixInitial);
		    article.setUtilisateur(utilisateur);
		    article.setPrixVente(prixVente);
		    article.setCategorie(categorie);
		    
		    manager.add(article);
			request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
		} catch (DALException e) {
			request.getRequestDispatcher("/WEB-INF/newSale.jsp").forward(request, response);
			e.printStackTrace();
		}
	    
	}

}
