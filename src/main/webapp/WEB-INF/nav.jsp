<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <link rel="stylesheet" href="css/nav.css" />
            <link rel="stylesheet" href="css/all.css" />
                <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" />
            
        

<!DOCTYPE html>
<nav>
    <h1>
    	<a href="${pageContext.request.contextPath}/EnchereServlet">
    		<p>Enchères Arnold</p>
		</a>
		
	</h1>
    <ul>
      <!--  CONDITION DE HORS CONNEXION -->
      <c:if test="${utilisateur == null}">
          <li>
              <a href="${pageContext.request.contextPath}/RegisterServlet">S'inscrire</a>
          </li>
          <li>
              <a href="${pageContext.request.contextPath}/ConnectionServlet">Se connecter</a>
          </li>
        </c:if>
		<c:if test="${utilisateur != null}">
      <!--  CONDITION DE CONNEXION -->
          <li>
              <a href="${pageContext.request.contextPath}/EnchereServlet">Enchères</a>
          </li>
          <li>
              <a href="${pageContext.request.contextPath}/NewSaleServlet">Vendre un article</a>
          </li>
          <li>
              <a href="${pageContext.request.contextPath}/ProfileServlet">Mon profil</a>
          </li>
          <li>
              <a href="${pageContext.request.contextPath}/LogoutServlet">Déconnexion</a>
          </li>
          </c:if>
      </ul>
</nav>
	
	<div class="bottom_bar">
	<c:choose>
	    <c:when test="${utilisateur != null}">
			<div class="connecter">
			<i class="fa-solid fa-circle"></i>
			 	<a href="${pageContext.request.contextPath}/ProfileServlet">${utilisateur.pseudo}</a>
			</div>
			<div><span>${utilisateur.credit}</span> crédit(s)</div>
	    </c:when>    
	    <c:otherwise>
	        <div class="deconnecter">
	        	<i class="fa-solid fa-circle"></i>
			 	<a href="${pageContext.request.contextPath}/ConnectionServlet">Vous êtes déconnecté</a>
			</div>
	    </c:otherwise>
	</c:choose>
	</div>


