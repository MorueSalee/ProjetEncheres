package fr.formation.enchere.ihm;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import fr.formation.enchere.bll.ArticleVenduManager;
import fr.formation.enchere.bll.ArticleVenduManagerSing;
import fr.formation.enchere.bo.ArticleVendu;
import fr.formation.enchere.bo.Utilisateur;
import fr.formation.enchere.dal.DALException;

/**
 * Servlet implementation class DetailSaleServlet
 */
public class DetailSaleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArticleVenduManager manager = ArticleVenduManagerSing.getInstance();

       
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
        HttpSession session = request.getSession();
        
        String noArticleParam = request.getParameter("noArticle");

        try {
            Integer noArticle = Integer.parseInt(noArticleParam);
            ArticleVendu currentArticle = manager.getById(noArticle);
            request.setAttribute("currentArticle", currentArticle);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (DALException e) {
            e.printStackTrace();
        }
                
        request.getRequestDispatcher("/WEB-INF/detailSale.jsp").forward(request, response);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String propositionStr = request.getParameter("proposition");
		System.out.println(propositionStr);
		
        request.getRequestDispatcher("/WEB-INF/detailSale.jsp").forward(request, response);
	}

}
