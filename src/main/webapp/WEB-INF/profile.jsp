<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/profile.css">
    <link rel="stylesheet" href="css/all.css" />

    <title>Document</title>
</head>
<body>
      <jsp:include page="nav.jsp"/>
    <h2>Profil</h2>
    <section id="profile" class="container">
        <div>
            <p>Nom : </p>
            <p>${sessionScope.utilisateur.nom}</p>
        </div>
        <div>
            <p>Pr�nom : </p>
            <p>${sessionScope.utilisateur.prenom}</p>
        </div>
        <div>
            <p>Email : </p>
            <p>${sessionScope.utilisateur.email}</p>
        </div>
        <div>
            <p>Téléphone : </p>
            <p>${sessionScope.utilisateur.telephone}</p>
        </div>
        <div>
            <p>Rue : </p>
            <p>${sessionScope.utilisateur.rue}</p>
        </div>
        <div>
            <p>Code postale : </p>
            <p>${sessionScope.utilisateur.codePostal}</p>
        </div>
        <div>
            <p>Ville : </p>
            <p>${sessionScope.utilisateur.ville}</p>
        </div>
        <!-- CONDITION SI C'EST NOTRE PROFIL UTILISATEUR -->
        <div class="button_update_profile">
            <a href="${pageContext.request.contextPath}/UpdateProfileServlet">Modifier</button>
        </div>
    </section>
</body>
</html>