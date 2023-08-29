<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/connection.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/connection.css" />
    <title>Document</title>
</head>
<body>
    <nav>
        <h1>ENI - Enchere</h1>
        <ul>
          <li>
            <a href="">S'inscrire</a>
          </li>
          <li>
            <a href="">Se connecter</a>
          </li>
        </ul>
    </nav>
    <h2>Connexion</h2>
    <section id="connection" class="container">
        <form>
            <div>
                <label>Identifiant : </label>
                <input />
            </div>
            <div>
                <label>Mot de passe : </label>
                <input />
            </div>
            <div>
                <a href="${pageContext.request.contextPath}/EnchereServlet"">Connexion</a>
                <div>
                    <div class="connection_checkbox">
                        <input type="checkbox">
                        <label>Se souvenir de moi</label>
                    </div>
                    <a href="#">Mot de passe oublié</a>
                </div>
            </div>
        </form>
    </section>
</body>
</html>