<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/updateProfile.css">
    <link rel="stylesheet" href="css/all.css" />
    
    <jsp:include page="head.jsp"/>
</head>
<body>
      <jsp:include page="nav.jsp"/>
      
      <section id="update_profile" class="container">
      <h2>Mise à jour profil</h2>
        <form action="UpdateProfileServlet"  method="post">
            <div class="form_update">
            
               <div class="d-flex position">
               		<div class="title">
	                   <label>Pseudo *</label>
	                   <i class="fa-solid fa-id-card-clip"></i>
	                </div>
	                <input type="text" value="${sessionScope.utilisateur.pseudo}" name="pseudo" required/>
               </div>
               <div class="d-flex">
	               <div class="position">
	               		<div class="title">
	                   		<label>Prénom</label>
	                   		<i class="fa-solid fa-user"></i>
	                   	</div>
	                   <input type="text" value="${sessionScope.utilisateur.prenom}" name="prenom"/>
	               </div>
	               <div class="position">
	               		<div class="title">
		                   <label>Nom</label>
		                   <i class="fa-solid fa-id-card-clip"></i>
	                   </div>
	                   <input type="text" value="${sessionScope.utilisateur.nom}" name="nom"/>
	               </div>
	           </div>
	           <div class="d-flex">
	               <div class="position">
	               		<div class="title">
		                   <label>Téléphone</label>
		                   <i class="fa-solid fa-phone"></i>
	                   </div>
	                   <input type="text" value="${sessionScope.utilisateur.telephone}" name="telephone"/>
	               </div>
	               <div class="position">
	               		<div class="title">
		                   <label>Email *</label>
		                   <i class="fa-solid fa-envelope"></i>
	                   </div>
	                   <input type="text" value="${sessionScope.utilisateur.email}" name="email" required/>
	               </div>
               </div>
               <div class="d-flex">
	               <div class="position">
	               		<div class="title">
	                   		<label>Rue</label>
	                   		<i class="fa-solid fa-street-view"></i>
	                   </div>
	                   <input type="text" value="${sessionScope.utilisateur.rue}" name="rue"/>
	               </div>
	               <div class="position">
	               		<div class="title">
	                   		<label>Ville</label>
	                   		<i class="fa-solid fa-city"></i>
	                   </div>
	                   <input type="text" value="${sessionScope.utilisateur.ville}" name="ville"/>
	               </div>
	               <div class="position">
	               		<div class="title">
	                   		<label>Code postal</label>
	                   		<i class="fa-solid fa-building"></i>
	                   </div>
	                   <input type="text" value="${sessionScope.utilisateur.codePostal}" name="codePostal"/>
	               </div>
	           </div>
	           <div class="d-flex">
	               <div class="position">
					    <div class="title">
					        <label>Mot de passe *</label>
					        <i class="fa-solid fa-lock"></i>
					    </div>
					    <input type="password" name="motDePasseUpdate" required />
					</div>
					<div class="position">
					    <div class="title">
					        <label>Confirmation *</label>
					        <i class="fa-solid fa-lock"></i>
					    </div>
					    <input type="password" name="motDePasseUpdate2" required />
					</div>

	           </div>
	           <p class="obligatory">* Champs obligatoire</p>
	             <!--  CONDITION DE MODIFICATION PROFIL UTILISATEUR -->
	            <div class="profile_button">
	                <input type="submit" value="Enregistrer"/>
	                <a href="${pageContext.request.contextPath}/deleteProfile"><i class="fa-solid fa-trash"></i></a>
	            </div>
            </div>
            
        </form>
        ${message}
      </section>
</body>
</html>