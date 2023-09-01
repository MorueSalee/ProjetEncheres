<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/formUpdateRegister.css">
    <link rel="stylesheet" href="css/all.css" />
    
    <title>Mise à jour profil</title>
</head>
<body>
      <jsp:include page="nav.jsp"/>
      <h2>Mise à jour profil</h2>
      <section id="profile_register" class="container">
        <form action="UpdateProfileServlet"  method="post">
            <div class="form_profile_register">
                <div class="form_left">
                    <div>
                        <label>Pseudo :</label>
                        <input type="text" value="${sessionScope.utilisateur.pseudo}" name="pseudo">
                    </div>
                    <div>
                        <label>Prénom :</label>
                        <input type="text" value="${sessionScope.utilisateur.prenom}" name="prenom">
                    </div>
                    <div>
                        <label>Téléphone :</label>
                        <input type="text" value="${sessionScope.utilisateur.telephone}" name="telephone">
                    </div>
                    <div>
                        <label>Code postal :</label>
                        <input type="text" value="${sessionScope.utilisateur.codePostal}" name="codePostal">
                    </div>
                    <div>
                        <label>Mot de passe :</label>
                        <input type="text" value="${sessionScope.utilisateur.motDePasse}" name="motDePasse">
                    </div>
                </div>
                <div class="form_right">
                    <div>
                        <label>Nom :</label>
                        <input type="text" value="${sessionScope.utilisateur.nom}" name="nom">
                    </div>
                    <div>
                        <label>Email :</label>
                        <input type="text" value="${sessionScope.utilisateur.email}" name="email">
                    </div>
                    <div>
                        <label>Rue :</label>
                        <input type="text" value="${sessionScope.utilisateur.rue}" name="rue">
                    </div>
                    <div>
                        <label>Ville :</label>
                        <input type="text" value="${sessionScope.utilisateur.ville}" name="ville">
                    </div>
                    <div>
                        <label>Confirmation :</label>
                        <input type="text" name="motDePasse2">
                    </div>
                </div>
            </div>
             <!--  CONDITION DE MODIFICATION PROFIL UTILISATEUR -->
            <div class="profile_button">
                <input type="submit" value="enregistrer"/>
                <a href="${pageContext.request.contextPath}/deleteProfile">Supprimer mon compte</a>
            </div>
        </form>
        ${message}
      </section>
</body>
</html>