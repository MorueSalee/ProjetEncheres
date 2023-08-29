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
    <nav>
        <h1>ENI - Enchere</h1>
      </nav>
      <h2>S'inscrire</h2>
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
            <!--  CONDITION D'INSCRIPTION -->
            <div class="register_button">
                <a href="${pageContext.request.contextPath}/EnchereServlet">Créer</a>
                <a href="${pageContext.request.contextPath}/ConnectionServlet">Annuler</a>
            </div>
        </form>
      </section>
</body>
</html>