package fr.formation.enchere.ihm;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.LocalDate;

import fr.formation.enchere.bll.ArticleVenduManager;
import fr.formation.enchere.bll.ArticleVenduManagerSing;
import fr.formation.enchere.bll.EnchereManager;
import fr.formation.enchere.bll.EnchereManagerSing;
import fr.formation.enchere.bo.ArticleVendu;
import fr.formation.enchere.bo.Enchere;
import fr.formation.enchere.bo.Utilisateur;
import fr.formation.enchere.dal.DALException;

/**
 * Servlet implementation class DetailSaleServlet
 */
public class DetailSaleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArticleVenduManager articleManager = ArticleVenduManagerSing.getInstance();
	private EnchereManager enchereManager = EnchereManagerSing.getInstance();

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailSaleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {        
        String noArticleParam = request.getParameter("noArticle");

        try {
            Integer noArticle = Integer.parseInt(noArticleParam);
            ArticleVendu currentArticle = articleManager.getById(noArticle);
            request.setAttribute("currentArticle", currentArticle);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (DALException e) {
            e.printStackTrace();
        }
            
        request.setAttribute("noArticle", noArticleParam);

        request.getRequestDispatcher("/WEB-INF/detailSale.jsp").forward(request, response);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String noArticleParam = (String) request.getParameter("noArticle");
		
		//Bouton encherir
		if (request.getParameter("encherir") != null) {
			
			try {
				Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
				ArticleVendu currentArticle = articleManager.getById(Integer.parseInt(noArticleParam));
				Enchere enchere = new Enchere(LocalDate.now(), Integer.parseInt(request.getParameter("montant")), utilisateur);
				
				
				currentArticle.addEnchere(enchere);
				currentArticle.setPrixVente(enchere.getMontantEnchere());
				
				enchereManager.add(enchere);
				
				articleManager.update(currentArticle);
				
				request.setAttribute("article", currentArticle);
				
			} catch (NumberFormatException | DALException e) {
				e.printStackTrace();
			}
						
		}		
		
		request.setAttribute("noArticle", noArticleParam);
		
        request.getRequestDispatcher("/WEB-INF/detailSale.jsp").forward(request, response);
		//response.sendRedirect("EnchereServlet");
	}

}
