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
    
    <title>Document</title>
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
	        	Je vais sortir mon porte-feuille très lentement de ma poche, j'ai plein de liquide. A moins que... vous acceptez les cartes de crédit ?
	        	<i class="fa-solid fa-quote-right"></i>
        	</p>
        	<img src="img/panpan_steven_seagal.png" alt="">
        </div>
        <div class="body_detail">
            <p>${currentArticle.nomArticle}</p>
            <div>
                <p>${currentArticle.description}</p>
            </div>
            <div>
                <p>${currentArticle.categorie.libelle}</p>
            </div>
            <div>
                <p>${currentArticle.prixVente}</p>
            </div>
            <div>
                <p>${currentArticle.dateDebutEncheres}</p>
            </div>
            <div>
                <p>${currentArticle.dateFinEncheres}</p>
            </div>
            <div>
                <p>${currentArticle.retrait.rue}</p>
            </div>
            <div>
                <p>${currentArticle.utilisateur.pseudo}</p>
            </div>
            <c:choose>
			    <c:when test="${utilisateur != null}">
			        <form action="<%=request.getContextPath()%>/detailArticle/${article.noArticle}" method="post">
	                <p>Ma proposition : </p>
	                <input type="number" value="${currentArticle.prixVente}" name="proposition">
	                <input type="submit" value="Enchérir"  />
	            </form>
			    </c:when>    
			    <c:otherwise>
			        <p class="noconnect">Vous devez être connecté pour enchérir</p>
			    </c:otherwise>
			</c:choose>
			            
        </div>
        
    </section>
</body>
</html>