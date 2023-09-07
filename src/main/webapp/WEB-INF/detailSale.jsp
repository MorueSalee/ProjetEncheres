<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/detailSale.css">
    <link rel="stylesheet" href="css/all.css" />
    <jsp:include page="head.jsp"/>
</head>
<body>

    <jsp:include page="nav.jsp"/>
    
    <section id="detail_sale" class="container">
    	<h2>Détail vente</h2>
    	<c:url value="/detailSaleServlet" var="detailUrl">
    		<c:param name="noArticle" value="${param.noArticle}" />
		</c:url>
		<div class="panpan_seagal">
        	<p class="replique">
	        	<i class="fa-solid fa-quote-left"></i>
	        	Sarah Connor ?
	        	<i class="fa-solid fa-quote-right"></i>
        	</p>
        	<img src="img/panpan_arnold.png" alt="">
        </div>
        <div class="body_detail">
        	<c:if test="${currentArticle.etatVente == 'Enchères terminées' }">
        		<div class="win">
        		 	<c:forEach var="encheres" items="${currentArticle.listeEncheres}" varStatus="status">
       					<c:if test="${status.last}">
           					<p class="winp">${encheres.utilisateur.pseudo} a remporté l'enchère !</p>
       					</c:if>
        		 	</c:forEach>
        		 </div>
        		 </br>
       		</c:if>
        	
        	<div>
        		<p>Nom article :</p>
            	<p>${currentArticle.nomArticle}</p>
            </div>
            <div>
            	<p>Description :</p>
                <p>${currentArticle.description}</p>
            </div>
            <div>
				<p>Catégorie : </p>
                <p>${currentArticle.categorie.libelle}</p>
            </div>
            <div>
           		<p>Point de retrait : </p>
                <p>${currentArticle.retrait.rue}, ${currentArticle.retrait.codePostal} ${currentArticle.retrait.ville}</p>
            </div>
            <div>
            	<p>Statut : </p>
                <p>${currentArticle.etatVente}</p>
            </div>
            <div>
            	<p>Vendeur : </p>
                <p>${currentArticle.utilisateur.pseudo}</p>
            </div>
            <div>
            	<p>Début des enchères : </p>
                <p>${currentArticle.dateDebutEncheres}</p>
            </div>
            <div>
            	<p>Fin des enchères : </p>
                <p>${currentArticle.dateFinEncheres}</p>
            </div>
            <div>
            	<p>Prix de départ : </p>
                <p>${currentArticle.prixInitial}</p>
            </div>
            <div>
            	<p>Meilleure offre : </p>
                <p>${currentArticle.prixVente}</p>

            </div>
            <c:choose>
			    <c:when test="${utilisateur != null}">
			        <form action="<%=request.getContextPath()%>/DetailSaleServlet?noArticle=${noArticle}" method="post">

			            <div class="encherir">   
			                <div class="title">
			                	<label>Ma proposition : </label>
			                	<i class="fa-solid fa-dollar-sign"></i>
			                </div>
			                <input  type="number" value="${currentArticle.prixVente + 1}" name="montant">
		                </div>
		                <input class="btn_encherir" type="submit" value="EnchÃ©rir" name="encherir"/>
	            	</form>
			    </c:when>    
			    <c:otherwise>
			        <p class="noconnect">Vous devez être connecté pour enchérir</p>
			    </c:otherwise>
			</c:choose>
			<div>
        		<p>${message}</p>
        	</div>			            
        </div>
    </section>
</body>
</html>