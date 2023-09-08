<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/newSale.css">
    <link rel="stylesheet" href="css/all.css" />
    
    <jsp:include page="head.jsp"/>
</head>
<body>
      <jsp:include page="nav.jsp"/>
      
    <section id="new_sale" class="container">
    	<h2>Nouvelle vente</h2>
        <form action="NewSaleServlet"  method="post">
            <img src="" alt=""/>
            <div class="body_new_sale">
                <div class="position">
                	<div class="title">
                    	<label>Article :</label>
                    	<i class="fa-solid fa-newspaper"></i>
                    </div>
                    <input type="text" name="nomArticle" required/>
                </div>
                <div class="position">
                	<div class="title">
                    	<label>Description :</label>
                    	<i class="fa-solid fa-file"></i>
                    </div>
                    <textarea type="description" name="description" required></textarea>
                </div>
                <div class="position">
		          <div class="title">
		          	<label for="categorie">Catégorie :</label>
		          </div>
		          <select name="categorie" class="input" id="categorie">
		          	<c:forEach items="${categories}" var="categorie" >
		          		<option value="${categorie.noCategorie}">${categorie.libelle}</option>
		          	</c:forEach>
		          </select>
		        </div>
                <div class="position">
                	<div class="title">
                    	<label>Photo de l'article :</label>
                    	<i class="fa-solid fa-image"></i>
                    </div>
                    <input type="file" name="imageUrl">
                </div>
                <div class="position">
                	<div class="title">
                    	<label>Mise à prix :</label>
                    	<i class="fa-solid fa-dollar-sign"></i>
                    </div>
                    <input type="number" name="prixInitial" required>
                </div>
                <div class="position">
                	<div class="title">
                    	<label>Début de l'enchère :</label>
                    	<i class="fa-solid fa-flag-checkered"></i>
                    </div>
                    <input type="date" name="dateDebutEncheres" required/>

                </div>
                <div class="position">
                	<div class="title">
                    	<label>Fin de l'enchère :</label>
                    	<i class="fa-solid fa-hourglass-end"></i>
                    </div>
                    <input type="date" name="dateFinEncheres" required/>
                </div>
                <div class="retrait">
                    <h4>Retrait</h4>
                    <div class="position">
                    	<div class="title">
                        	<label>Rue :</label>
                        	<i class="fa-solid fa-street-view"></i>
                        </div>
                        <input type="text" value="${sessionScope.utilisateur.rue}" name="rue"/>
                    </div>
                    <div class="position">
                    	<div class="title">
                        	<label>Code postale :</label>
                        	<i class="fa-solid fa-building"></i>
                        </div>
                        <input type="text" value="${sessionScope.utilisateur.codePostal}" name="codePostale"/>
                    </div>
                    <div class="position">
                    	<div class="title">
                        	<label>Ville :</label>
                        	<i class="fa-solid fa-city"></i>
                        </div>
                        <input type="text" value="${sessionScope.utilisateur.ville}" name="ville"/>
                    </div>
                </div>
                <div >
                    <input class="btn_new_sale" type="submit" value="Enregistrer">
                </div>
            </div>
            <p>${message}</p>
        </form>
    </section>
</body>
</html>