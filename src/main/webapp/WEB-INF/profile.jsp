<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/profile.css">
      <link rel="stylesheet" href="${pageContext.request.contextPath}/profile.css" />

    <title>Document</title>
</head>
<body>
      <jsp:include page="nav.jsp"/>
    <h2>Profil</h2>
    <section id="profile" class="container">
        <div>
            <p>Nom : </p>
            <p>${sessionScope.utilisateur.email}</p>
        </div>
        <div>
            <p>Prénom : </p>
            <p>MorueSalée</p>
        </div>
        <div>
            <p>Email : </p>
            <p>MorueSalée</p>
        </div>
        <div>
            <p>Téléphone : </p>
            <p>MorueSalée</p>
        </div>
        <div>
            <p>Rue : </p>
            <p>MorueSalée</p>
        </div>
        <div>
            <p>Code postale : </p>
            <p>MorueSalée</p>
        </div>
        <div>
            <p>Ville : </p>
            <p>MorueSalée</p>
        </div>
        <!-- CONDITION SI C'EST NOTRE PROFIL UTILISATEUR -->
        <div class="button_update_profile">
            <button>Modifier</button>
        </div>
    </section>
</body>
</html>