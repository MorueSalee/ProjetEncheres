<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/formUpdateRegister.css">
       <link rel="stylesheet" href="${pageContext.request.contextPath}/formUpdateRegister.css" />
    
    <title>S'inscrire</title>
</head>
<body>
      <jsp:include page="nav.jsp"/>
      <h2>S'inscrire</h2>
      <section id="profile_register" class="container">
        <form action="RegisterServlet"  method="post">
            <div class="form_profile_register">
                <div class="form_left">
                    <div>
                        <label>Pseudo :</label>
                        <input type="text" name="pseudo"/>
                    </div>
                    <div>
                        <label>Prénom :</label>
                        <input type="text" name="prenom"/>
                    </div>
                    <div>
                        <label>Téléphone :</label>
                        <input type="text" name="telephone"/>
                    </div>
                    <div>
                        <label>Code postal :</label>
                        <input type="text" name="codePostal"/>
                    </div>
                    <div>
                        <label>Mot de passe :</label>
                        <input type="text" name="motDePasse" />
                    </div>
                </div>
                <div class="form_right">
                    <div>
                        <label>Nom :</label>
                        <input type="text" name="nom"/>
                    </div>
                    <div>
                        <label>Email :</label>
                        <input type="text" name="email"/>
                    </div>
                    <div>
                        <label>Rue :</label>
                        <input type="text" name="rue"/>
                    </div>
                    <div>
                        <label>Ville :</label>
                        <input type="text" name="ville"/>
                    </div>
                    <div>
                        <label>Confirmation :</label>
                        <input type="password"/>
                    </div>
                </div>
            </div>
            <!--  CONDITION D'INSCRIPTION -->
            <div class="register_button">
                <input type="submit" value="Inscription"/> 
                <a href="${pageContext.request.contextPath}/ConnectionServlet">Annuler</a>
            </div>
        </form>
      </section>
</body>
</html>