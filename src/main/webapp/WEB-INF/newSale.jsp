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
    
    <title>Document</title>
</head>
<body>
      <jsp:include page="nav.jsp"/>
      <h2>Nouvelle vente</h2>
    <section id="new_sale" class="container">
        <form action="NewSaleServlet"  method="post">
            <img src="" alt=""/>
            <div>
                <div>
                    <label>Article :</label>
                    <input type="text" name="nomArticle" required/>
                </div>
                <div>
                    <label>Description :</label>
                    <textarea type="description" name="description" required></textarea>
                </div>
                <div> 
                
		          	<p>${categorie.libelle}</p>
		          
		          <label for="categorie">Catégorie :</label>
		          <select name="categorie" class="input" id="categorie">
		          	<c:forEach items="${categories}" var="categorie" >
		          		<option value="${categorie.noCategorie}">${categorie.libelle}</option>
		          	</c:forEach>
		          </select>
		        </div>
                <div>
                    <label>Photo de l'article :</label>
                    <input type="file" >
                </div>
                <div>
                    <label>Mise à prix :</label>
                    <input type="number" name="prixInitial" required>
                </div>
                <div>
                    <label>Début de l'enchère :</label>
                    <input type="date" name="dateDebutEncheres" required/>

                </div>
                <div>
                    <label>Fin de l'enchère :</label>
                    <input type="date" name="dateFinEncheres" required/>
                </div>
                <div class="retrait">
                    <h4>Retrait</h4>
                    <div>
                        <label>Rue :</label>
                        <input type="text" value="${sessionScope.utilisateur.rue}" name="rue"/>
                    </div>
                    <div>
                        <label>Code postale :</label>
                        <input type="text" value="${sessionScope.utilisateur.codePostal}" name="codePostale"/>
                    </div>
                    <div>
                        <label>Ville :</label>
                        <input type="text" value="${sessionScope.utilisateur.ville}" name="ville"/>
                    </div>
                </div>
                <div>
                    <input type="submit" value="Enregistrer">
                    <button>Annuler</button>
                    <button>Annuler la vente</button>
                </div>
            </div>
        </form>
    </section>
</body>
</html>