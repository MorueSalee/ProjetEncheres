<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/all.css" />
    <link rel="stylesheet" href="css/connection.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" />
	<jsp:include page="head.jsp"/>
</head>
<body>
    <jsp:include page="nav.jsp"/>
    <section id="connection" class="container">
        <form action="ConnectionServlet" method="post">
        	<h2>Login.</h2>
            <div>
            	<div class="title">
	                <label>Identifiant</label>
					 <i class="fa-solid fa-address-card"></i>
				 </div>
                <input type="text" name="identifiant" required/>
            </div>
            <div>
            	<div class="title">
                	<label>Mot de passe</label>
                	<i class="fa-solid fa-lock"></i>
                </div>
                <input type="password" name="motDePasse" required/>
            </div>
            <div>
                <div class="remember">
                    <div class="connection_checkbox">
                        <input type="checkbox">
                        <a>Se souvenir de moi</label>
                    </div>
                    <a href="#">Mot de passe oublie</a>
                </div>
				<input class="btn_connection" type="submit" value="Connexion"/> 
            </div>
        </form>
        <p>${message}</p>
        <img src="img/sourire.png" />
    </section>
</body>
</html>