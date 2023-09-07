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
import fr.formation.enchere.bll.UtilisateurManager;
import fr.formation.enchere.bll.UtilisateurManagerSing;
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
	private UtilisateurManager utilisateurManager = UtilisateurManagerSing.getInstance();

       
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
		String message = null;
		
		//Bouton encherir
		if (request.getParameter("encherir") != null) {
			
			try {
				
				ArticleVendu currentArticle = articleManager.getById(Integer.parseInt(noArticleParam));
				Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
				// Vérif si article en cours
				if (currentArticle.getEtatVente().equals("En cours")) {
					//Verif si une enchere existe
					if (currentArticle.getListeEncheres().isEmpty()) {
						
						//Verif si l'enchere a été créé par l'utilisateur
						if (utilisateur.getNoUtilisateur() != currentArticle.getUtilisateur().getNoUtilisateur()) {
							
							//Verif si le montant est correct
							if (Integer.parseInt(request.getParameter("montant")) > currentArticle.getPrixVente()) {
								
								//Verif si l'utilisateur a assez de crédit
								if (utilisateur.getCredit() >= Integer.parseInt(request.getParameter("montant"))) {
									
									Enchere enchere = new Enchere(LocalDate.now(), Integer.parseInt(request.getParameter("montant")), utilisateur);
									
									currentArticle.addEnchere(enchere);
									currentArticle.setPrixVente(enchere.getMontantEnchere());
									utilisateur.setCredit(utilisateur.getCredit() - enchere.getMontantEnchere());
									
									enchereManager.add(enchere);
									utilisateurManager.update(utilisateur);
									articleManager.update(currentArticle);
									
									message = "Bravo votre enchère a été acceptée !";
									
								} else {
									message = "Vous n'avez pas assez de crédit !";
								}
								
							} else {
								message = "Le montant de votre enchère est insuffisant !";
							}						
						} else {
							message = "Vous ne pouvez pas enchérir sur votre propre vente !";
						}
						
					} else {
						
						Enchere derniereEnchere = currentArticle.getListeEncheres().get(currentArticle.getListeEncheres().size() - 1);
						
						//Verif si l'enchere a été créé par l'utilisateur
						if (utilisateur.getNoUtilisateur() != currentArticle.getUtilisateur().getNoUtilisateur()) {
							
							//Verif si la derniere enchere est celle de l'utilisateur
							if (utilisateur.getNoUtilisateur() != derniereEnchere.getUtilisateur().getNoUtilisateur()) {
								
								//Verif si le montant est correct
								if (Integer.parseInt(request.getParameter("montant")) > currentArticle.getPrixVente()) {
									
									//Verif si l'utilisateur a assez de crédit
									if (utilisateur.getCredit() >= Integer.parseInt(request.getParameter("montant"))) {
										
										Utilisateur encherisseurPrecedant = derniereEnchere.getUtilisateur();
										Integer encherePrecedante = derniereEnchere.getMontantEnchere();
										Enchere enchere = new Enchere(LocalDate.now(), Integer.parseInt(request.getParameter("montant")), utilisateur);
										
										encherisseurPrecedant.setCredit(encherisseurPrecedant.getCredit() + encherePrecedante);
										currentArticle.addEnchere(enchere);
										currentArticle.setPrixVente(enchere.getMontantEnchere());
										utilisateur.setCredit(utilisateur.getCredit() - enchere.getMontantEnchere());
										
										enchereManager.add(enchere);
										utilisateurManager.update(utilisateur);
										utilisateurManager.update(encherisseurPrecedant);
										articleManager.update(currentArticle);
										
										message = "Bravo votre enchère a été acceptée !";
										
									} else {
										message = "Vous n'avez pas assez de crédit !";
									}
								} else {
									message = "Le montant de votre enchère est insuffisant !";
								}						
							}else {
								message = "Vous avez déjà enchéri sur cette enchère !";
							}
						} else {
							message = "Vous ne pouvez pas enchérir sur votre propre vente !";
						}
					}
				} else {
					message = "La vente n'est plus en cours !";
				}
				request.setAttribute("currentArticle", currentArticle);
				request.setAttribute("message", message);
				
			} catch (NumberFormatException | DALException e) {
				e.printStackTrace();
			}
						
		}		
		
		request.setAttribute("noArticle", noArticleParam);
		
        request.getRequestDispatcher("/WEB-INF/detailSale.jsp").forward(request, response);
		//response.sendRedirect("DetailSaleServlet");
	}

}
