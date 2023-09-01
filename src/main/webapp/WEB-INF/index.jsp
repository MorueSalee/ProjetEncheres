<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
  <title>Enchères</title>
  <link rel="stylesheet" href="css/index.css" />
  <link rel="stylesheet" href="css/all.css" />
  
</head>
<body>
  <jsp:include page="nav.jsp"/>
  <h2 class="text-3xl font-bold underline">Liste des enchères</h2>
  <section class="container">
    <form class="section_search">
      <div class="filter">
        <div >
          <label>Filtres :</label>
          <input type="text" name="nomArticle"/>
        </div>
        <div>
          <label>Catégories : </label>
          <select name="categorie" id="">
          	<option>Toutes</option>
            <option>Informatique</option>
            <option>Ameublement</option>
            <option>Vêtement</option>
            <option>Sport&Loisirs</option>
          </select>
        </div>
        <c:if test="${utilisateur != null}">
	        <div class="filter_radio">
	          <div>
	            <div>
	              <input type="radio" id="achats_radio" name="filter_radio" checked>
	              <label for="achats_radio">Achats</label>
	            </div>
	            <div class="sous_filter">
	              <div>
	                <input type="checkbox" id="ench_open" checked/>
	                <label for="ench_open">enchères ouvertes</label>
	              </div>
	              <div>
	                <input type="checkbox" id="ench_current"/>
	                <label for="ench_current">mes enchères en cours</label>
	              </div>
	              <div>
	                <input type="checkbox" id="ench_won"/>
	                <label for="ench_won">mes enchères remportées</label>
	              </div>
	            </div>
	          </div>
	          <div>
	            <div>
	              <input type="radio" id="ventes_radio" name="filter_radio">
	              <label for="ventes_radio">Mes ventes</label>
	            </div>
	            <div class="sous_filter">
	              <div>
	                <input type="checkbox" id="vente_ongoing" disabled="disabled" checked/>
	                <label for="vente_ongoing">mes ventes en cours</label>
	              </div>
	              <div>
	                <input type="checkbox" id="vente_not_started" disabled="disabled"/>
	                <label for="vente_not_started">ventes non débutées</label>
	              </div>
	              <div>
	                <input type="checkbox" id="vente_completed" disabled="disabled"/>
	                <label for="vente_completed">ventes terminées</label>
	              </div>
	            </div>
	          </div>
	       </div>
      </c:if>
      </div>
      <input type="submit" name="btnRechercher" value="Rechercher">
    </form>
  </section>
  <section class="container">
    <div class="grid_article">
    	<c:forEach items="${articleModel.listArticle}" var="article">
	      <div class="card_article">
	        <img src="" alt="">
	        <div>
	          <h3>${article.nomArticle}</h3>
	          <p>Prix : ${article.prixVente}</p>
	          <fmt:parseDate value="${article.dateFinEncheres}" pattern="yyyy-MM-dd" var="st" type="both"/>
	          <p>Fin de l'enchère : <fmt:formatDate pattern="dd/MM/yyyy" value="${st}" /></p>
	          <p>Vendeur : ${article.utilisateur.pseudo}</p>
	        </div>
	      </div>
      	</c:forEach>
    </div>
  </section>
  
</body>
</html>
<script src="js/indexRadioSwitch.js"></script>