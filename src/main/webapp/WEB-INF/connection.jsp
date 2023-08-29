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
                    <a href="#">Mot de passe oubli�</a>
                </div>
            </div>
        </form>
    </section>
</body>
</html>