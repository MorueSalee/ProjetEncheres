<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/register.css">
    <link rel="stylesheet" href="css/all.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" />
    <title>S'inscrire</title>
</head>
<body>
      <jsp:include page="nav.jsp"/>
      
      <section id="register" class="container">
      <h2>S'inscrire</h2>
      <div class="body">
        <form action="RegisterServlet"  method="post">
            <div class="form_register">
               <div class="d-flex position">
               		<div class="title">
	                   <label>Pseudo *</label>
	                   <i class="fa-solid fa-id-card-clip"></i>
	                </div>
	                <input type="text" name="pseudo" value="${empty param.pseudo ? '' : param.pseudo}" required/>
               </div>
               <div class="d-flex">
	               <div class="position">
	               		<div class="title">
	                   		<label>Prénom</label>
	                   		<i class="fa-solid fa-user"></i>
	                   	</div>
	                   <input type="text" name="prenom" value="${empty param.prenom ? '' : param.prenom}"/>
	               </div>
	               <div class="position">
	               		<div class="title">
		                   <label>Nom</label>
		                   <i class="fa-solid fa-id-card-clip"></i>
	                   </div>
	                   <input type="text" name="nom" value="${empty param.nom ? '' : param.nom}"/>
	               </div>
	           </div>
	           <div class="d-flex">
	               <div class="position">
	               		<div class="title">
		                   <label>Téléphone</label>
		                   <i class="fa-solid fa-phone"></i>
	                   </div>
	                   <input type="text" name="telephone" value="${empty param.telephone ? '' : param.telephone}"/>
	               </div>
	               <div class="position">
	               		<div class="title">
		                   <label>Email *</label>
		                   <i class="fa-solid fa-envelope"></i>
	                   </div>
	                   <input type="text" name="email" required value="${empty param.email ? '' : param.email}"/>
	               </div>
               </div>
               <div class="d-flex">
	               <div class="position">
	               		<div class="title">
	                   		<label>Rue</label>
	                   		<i class="fa-solid fa-street-view"></i>
	                   </div>
	                   <input type="text" name="rue" value="${empty param.rue ? '' : param.rue}"/>
	               </div>
	               <div class="position">
	               		<div class="title">
	                   		<label>Ville</label>
	                   		<i class="fa-solid fa-city"></i>
	                   </div>
	                   <input type="text" name="ville" value="${empty param.ville ? '' : param.ville}"/>
	               </div>
	               <div class="position">
	               		<div class="title">
	                   		<label>Code postal</label>
	                   		<i class="fa-solid fa-building"></i>
	                   </div>
	                   <input type="text" name="codePostal" value="${empty param.codePostal ? '' : param.codePostal}"/>
	               </div>
	           </div>
	           <div class="d-flex">
	               <div class="position">
	               		<div class="title">
	                   		<label>Mot de passe *</label>
	                   		<i class="fa-solid fa-lock"></i>
	                   	</div>
	                   <input type="password" name="motDePasse" required />
	               </div>
					<div class="position">
						<div class="title">
	                   		<label>Confirmation *</label>
	                   		<i class="fa-solid fa-lock"></i>
	                   </div>
	                   <input type="password" name="motDePasse2" required/>
	               </div>
	           </div>
            </div>
            <p class="obligatory">* Champs obligatoire</p>
            <!--  CONDITION D'INSCRIPTION -->
            <div class="register_button">
                <input class="btn_register" type="submit" value="Inscription"/> 
                <a href="${pageContext.request.contextPath}/ConnectionServlet">Annuler</a>
            </div>
            <p class="error">${message}</p>
        </form>
        <div class="seagal">
	        <p>
	        <i class="fa-solid fa-quote-left"></i>
	        Mon contact à Washington dit qu'on n'a pas affaire à un élève mais qu'on a affaire au professeur.
	        <i class="fa-solid fa-quote-right"></i>
	        </p>
	        <img src="img/bg_seagal.png" />
        </div>
       </div>
     </section>
</body>
</html>