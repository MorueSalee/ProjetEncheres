<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/formUpdateRegister.css">
       <link rel="stylesheet" href="${pageContext.request.contextPath}/formUpdateRegister.css" />
    
    <title>Mise à jour profil</title>
</head>
<body>
      <jsp:include page="nav.jsp"/>
      <h2>Mise à jour profil</h2>
      <section id="profile_register" class="container">
        <form>
            <div class="form_profile_register">
                <div class="form_left">
                    <div>
                        <label>Pseudo :</label>
                        <input />
                    </div>
                    <div>
                        <label>Prénom :</label>
                        <input />
                    </div>
                    <div>
                        <label>Téléphone :</label>
                        <input />
                    </div>
                    <div>
                        <label>Code postal :</label>
                        <input />
                    </div>
                    <div>
                        <label>Mot de passe :</label>
                        <input />
                    </div>
                </div>
                <div class="form_right">
                    <div>
                        <label>Nom :</label>
                        <input />
                    </div>
                    <div>
                        <label>Email :</label>
                        <input />
                    </div>
                    <div>
                        <label>Rue :</label>
                        <input />
                    </div>
                    <div>
                        <label>Ville :</label>
                        <input />
                    </div>
                    <div>
                        <label>Confirmation :</label>
                        <input />
                    </div>
                </div>
            </div>
             <!--  CONDITION DE MODIFICATION PROFIL UTILISATEUR -->
            <div class="profile_button">
                <button>Enregister</button>
                <button>Supprimer mon compte</button>
            </div>
        </form>
      </section>
</body>
</html>