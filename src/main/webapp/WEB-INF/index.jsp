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
</head>
<body>
  <jsp:include page="nav.jsp"/>
  <h2 class="text-3xl font-bold underline">Liste des enchères</h2>
  <section class="container">
    <form class="section_search">
      <div class="filter">
        <div >
          <label>Filtres :</label>
          <input />
        </div>
        <div>
          <label>Catégories : </label>
          <select name="" id="">
            <option>Informatique</option>
            <option>Ameublement</option>
            <option>Vêtement</option>
            <option>Sport&Loisirs</option>
          </select>
        </div>
        <div class="filter_radio">
          <div>
            <div>
              <input type="radio" id="" name="filter_radio">
              <label>Achats</label>
            </div>
            <div class="sous_filter">
              <div>
                <input type="checkbox"/>
                <label>enchères ouvertes</label>
              </div>
              <div>
                <input type="checkbox"/>
                <label>mes enchères en cours</label>
              </div>
              <div>
                <input type="checkbox"/>
                <label>mes enchères remportés</label>
              </div>
            </div>
          </div>
          <div>
            <div>
              <input type="radio" id="" name="filter_radio">
              <label>Mes ventes</label>
            </div>
            <div class="sous_filter">
              <div>
                <input type="checkbox"/>
                <label>mes ventes en cours</label>
              </div>
              <div>
                <input type="checkbox"/>
                <label>ventes non débutés</label>
              </div>
              <div>
                <input type="checkbox"/>
                <label>ventes terminés</label>
              </div>
            </div>
          </div>
       </div>
      </div>
      <button>Rechercher</button>
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