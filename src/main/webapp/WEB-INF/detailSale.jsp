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
    	<h2>D�tail vente</h2>
    	<c:url value="/detailSaleServlet" var="detailUrl">
    		<c:param name="noArticle" value="${param.noArticle}" />
		</c:url>
		<div class="panpan_seagal">
        	<p class="replique">
	        	<i class="fa-solid fa-quote-left"></i>
	        	Je vais sortir mon porte-feuille tr�s lentement de ma poche, j'ai plein de liquide. A moins que... vous acceptez les cartes de cr�dit ?
	        	<i class="fa-solid fa-quote-right"></i>
        	</p>
        	<img src="img/panpan_steven_seagal.png" alt="">
        </div>
        <div class="body_detail">
        	<div>
        		<p>Nom article:</p>
            	<p>${currentArticle.nomArticle}</p>
            </div>
            <div>
            	<p>Description:</p>
                <p>${currentArticle.description}</p>
            </div>
            <div>
                <p>Libelle:</p>
                <p>${currentArticle.categorie.libelle}</p>
            </div>
            <div>
                <p>Prix vente:</p>
                <p>${currentArticle.prixVente}</p>
            </div>
            <div>
                <p>Date d�but:</p>
                <p>${currentArticle.dateDebutEncheres}</p>
            </div>
            <div>
                <p>Date fin:</p>
                <p>${currentArticle.dateFinEncheres}</p>
            </div>
            <div>
                <p>Rue:</p>
                <p>${currentArticle.retrait.rue}</p>
            </div>
            <div>
                <p>Pseudo (vendeur):</p>
                <p>${currentArticle.utilisateur.pseudo}</p>
            </div>
            <c:choose>
			    <c:when test="${utilisateur != null}">
			        <form action="<%=request.getContextPath()%>/DetailSaleServlet?noArticle=${noArticle}" method="post">
			            <div class="encherir">   
			                <div class="title">
			                	<label>Ma proposition : </label>
			                	<i class="fa-solid fa-dollar-sign"></i>
			                </div>
			                <input  type="number" value="${currentArticle.prixVente}" name="montant">
		                </div>
		                <input class="btn_encherir" type="submit" value="Ench�rir" name="encherir"/>
	            	</form>
			    </c:when>    
			    <c:otherwise>
			        <p class="noconnect">Vous devez �tre connect� pour ench�rir</p>
			    </c:otherwise>
			</c:choose>
			            
        </div>
        
    </section>
</body>
</html>