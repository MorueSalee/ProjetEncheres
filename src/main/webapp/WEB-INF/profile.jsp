<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/profile.css">
    <link rel="stylesheet" href="css/all.css" />

   <jsp:include page="head.jsp"/>
</head>
<body>
      <jsp:include page="nav.jsp"/>
    
    <section id="profile" class="container">
    <h2>Profil</h2>
	    <div class="body">
	        <div>
	            <p>Nom:</p>
	            <p>${sessionScope.utilisateur.nom}</p>
	        </div>
	        <div>
	            <p>Prénom:</p>
	            <p>${sessionScope.utilisateur.prenom}</p>
	        </div>
	        <div>
	            <p>Email:</p>
	            <p>${sessionScope.utilisateur.email}</p>
	        </div>
	        <div>
	            <p>Téléphone:</p>
	            <p>${sessionScope.utilisateur.telephone}</p>
	        </div>
	        <div>
	            <p>Rue:</p>
	            <p>${sessionScope.utilisateur.rue}</p>
	        </div>
	        <div>
	            <p>Code postale:</p>
	            <p>${sessionScope.utilisateur.codePostal}</p>
	        </div>
	        <div>
	            <p>Ville:</p>
	            <p>${sessionScope.utilisateur.ville}</p>
	        </div>
        </div>
       	<div class="button_update_profile">
            <a href="${pageContext.request.contextPath}/UpdateProfileServlet">Modifier</button>
        </div>
        <img src="img/bg.png" alt="Image par défault"/>
   
    </section>
</body>
</html>