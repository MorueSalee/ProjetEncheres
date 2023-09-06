<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
  <title>EnchÃ¨res</title>
  <link rel="stylesheet" href="css/index.css" />
  <link rel="stylesheet" href="css/all.css" />
  
</head>
<body>
  <jsp:include page="nav.jsp"/>
  <section id="lst_enchere" class="container">
  	<h2 >Liste des enchéres</h2>
    <form action="EnchereServlet" method="post" class="section_search">
      <div class="filter">
        <div>
        	<div class="title">
          		<label>Recherche :</label>
          		<i class="fa-solid fa-magnifying-glass"></i>
          	</div>
          <input type="text" name="nomArticle"/>
        </div>
        <div>
          <div class="title">
            <label>Catégories : </label>
          </div>
            <select name="categorie" id="">
              <c:forEach items="${lstCategories}" var="categorie" >
                <option <c:if test="${searchCategorie == categorie.libelle}">selected</c:if>>${categorie.libelle}</option>
              </c:forEach>
            </select>
        </div>
        <c:if test="${utilisateur != null}">
	        <div class="filter_radio">
	          <div>
	            <div>
	              <input type="radio" id="achats_radio" name="filter_radio" value="1" <c:if test="${radioFilter == 1}">checked</c:if>>
	              <label for="achats_radio">Achats</label>
	            </div>
	            <div class="sous_filter">
	              <div>
	                <input type="checkbox" id="ench_open" name="1" value="1" <c:if test="${radioFilter == 2}">disabled="disabled"</c:if> <c:if test="${lstCheckBoxFilter[1] != null}">checked</c:if>/>
	                <label for="ench_open">enchéres ouvertes</label>
	              </div>
	              <div>
	                <input type="checkbox" id="ench_current" name="2" value="2" <c:if test="${radioFilter == 2}">disabled="disabled"</c:if> <c:if test="${lstCheckBoxFilter[2] != null}">checked</c:if>/>
	                <label for="ench_current">mes enchéres en cours</label>
	              </div>
	              <div>
	                <input type="checkbox" id="ench_won" name="3" value="3" <c:if test="${radioFilter == 2}">disabled="disabled"</c:if> <c:if test="${lstCheckBoxFilter[3] != null}">checked</c:if>/>
	                <label for="ench_won">mes enchéres remportées</label>
	              </div>
	            </div>
	          </div>
	          <div>
	            <div>
	              <input type="radio" id="ventes_radio" name="filter_radio" value="2" <c:if test="${radioFilter == 2}">checked</c:if>>
	              <label for="ventes_radio">Mes ventes</label>
	            </div>
	            <div class="sous_filter">
	              <div>
	                <input type="checkbox" id="vente_ongoing"  name="4" value="4" <c:if test="${radioFilter == 1}">disabled="disabled"</c:if> <c:if test="${lstCheckBoxFilter[4] != null}">checked</c:if>/>
	                <label for="vente_ongoing">mes ventes en cours</label>
	              </div>
	              <div>
	                <input type="checkbox" id="vente_not_started" name ="5" value="5" <c:if test="${radioFilter == 1}">disabled="disabled"</c:if> <c:if test="${lstCheckBoxFilter[5] != null}">checked</c:if>/>
	                <label for="vente_not_started">ventes non débutés</label>
	              </div>
	              <div>
	                <input type="checkbox" id="vente_completed" name="6" value="6" <c:if test="${radioFilter == 1}">disabled="disabled"</c:if> <c:if test="${lstCheckBoxFilter[6] != null}">checked</c:if>/>
	                <label for="vente_completed">ventes terminées</label>
	              </div>
	            </div>
	          </div>
	       </div>
      </c:if>
      </div>
      <input class="search" type="submit" name="btnRechercher" value="Rechercher">
    </form>
    <img src="img/steven-suit.png" />
  </section>
  <section id="all_article" class="container">
    <div class="grid_article">
    	<c:forEach items="${articleModel.listArticle}" var="article">
    	<a href="DetailSaleServlet?noArticle=${article.noArticle}">
	      <div class="card_article">
	        <img src="" alt="">
	        <div>
	          <h3>${article.nomArticle}</h3>
	          <p><span>Prix:</span> ${article.prixVente}</p>
	          <fmt:parseDate value="${article.dateFinEncheres}" pattern="yyyy-MM-dd" var="st" type="both"/>
	          <p><span>Fin de l'enchére:</span> <fmt:formatDate pattern="dd/MM/yyyy" value="${st}" /></p>
	           <p><span>Catégorie:</span> ${article.categorie.libelle}</p>
	          <p><span>Vendeur:</span> ${article.utilisateur.pseudo}</p>
	        </div>
	      </div>
	      </a>
      	</c:forEach>
    </div>
  </section>
  
</body>
</html>
<script src="js/indexRadioSwitch.js"></script>