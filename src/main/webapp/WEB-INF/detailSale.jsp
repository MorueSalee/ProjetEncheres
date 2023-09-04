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
    <h2>DÃ©tail vente</h2>
    <section id="detail_sale" class="container">
    	<c:url value="/detailSaleServlet" var="detailUrl">
    		<c:param name="noArticle" value="${param.noArticle}" />
		</c:url>
        <img src="" alt="">
        <div class="body_detail">
            <p>${currentArticle.nomArticle}</p>
            <div>
                <p>${currentArticle.description}</p>
            </div>
            <div>
                <p>${currentArticle.categorie.libelle}</p>
            </div>
            <div>
                ${currentArticle.prixVente}
            </div>
            <div>
                ${currentArticle.dateDebutEncheres}
            </div>
            <div>
                ${currentArticle.dateFinEncheres}
            </div>
            <div>
                ${currentArticle.retrait.rue}
            </div>
            <div>
                ${currentArticle.utilisateur.pseudo}
            </div>
            <form action="${pageContext.request.contextPath}/creditenchere?id=${param.id}" method="post">
                <p>Ma proposition : </p>
                <input type="number" value="${currentArticle.prixVente}" name="proposition">
                <input type="submit" value="Enchérir"  />
            </form>
        </div>
    </section>
</body>
</html>