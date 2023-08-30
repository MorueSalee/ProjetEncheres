<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/connection.css" />
    <title>Document</title>
</head>
<body>
    <jsp:include page="nav.jsp"/>
    <h2>Connexion</h2>
    <section id="connection" class="container">
        <form action="ConnectionServlet" method="post">
            <div>
                <label>Identifiant : </label>
                <input type="text" name="identifiant"/>
            </div>
            <div>
                <label>Mot de passe : </label>
                <input type="password" name="motDePasse"/>
            </div>
            <div>
                <input type="submit" value="Connexion"/> 
                <div>
                    <div class="connection_checkbox">
                        <input type="checkbox">
                        <label>Se souvenir de moi</label>
                    </div>
                    <a href="#">Mot de passe oublié</a>
                </div>
            </div>
        </form>
        <p>${message}</p>
    </section>
</body>
</html>