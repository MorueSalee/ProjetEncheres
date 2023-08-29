<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
  <title>Ench�res</title>
  <link rel="stylesheet" href="css/index.css" />
   <link rel="stylesheet" href="${pageContext.request.contextPath}/index.css" />
  
</head>
<body>
  <nav>
    <h1>ENI - Enchere</h1>
    <ul>
      <!--  CONDITION DE HORS CONNEXION -->
          <li>
              <a href="${pageContext.request.contextPath}/RegisterServlet">S'inscrire</a>
          </li>
          <li>
              <a href="${pageContext.request.contextPath}/ConnectionServlet">Se connecter</a>
          </li>

      <!--  CONDITION DE CONNEXION -->
          <li>
              <a href="">Ench�res</a>
          </li>
          <li>
              <a href="">Vendre un article</a>
          </li>
          <li>
              <a href="">Mon profil</a>
          </li>
          <li>
              <a href="">D�connexion</a>
          </li>
      </ul>
  </nav>
  <h2>Liste des ench�res</h2>
  <section class="container">
    <form class="section_search">
      <div class="filter">
        <div >
          <label>Filtres :</label>
          <input />
        </div>
        <div>
          <label>Cat�gories : </label>
          <select name="" id="">
            <option>Manteau</option>
            <option>Chaussure</option>
            <option>Bonnet</option>
            <option>Mat�riel informatique</option>
          </select>
        </div>
        <div class="filter_radio">
          <div>
            <div>
              <input type="radio" id="" name="filter_radio">
              <label>Achats</label>
            </div>
            <div class="sous_filter">
              <div>
                <input type="checkbox"/>
                <label>ench�res ouvertes</label>
              </div>
              <div>
                <input type="checkbox"/>
                <label>mes ench�res en cours</label>
              </div>
              <div>
                <input type="checkbox"/>
                <label>mes ench�res remport�s</label>
              </div>
            </div>
          </div>
          <div>
            <div>
              <input type="radio" id="" name="filter_radio">
              <label>Mes ventes</label>
            </div>
            <div class="sous_filter">
              <div>
                <input type="checkbox"/>
                <label>mes ventes en cours</label>
              </div>
              <div>
                <input type="checkbox"/>
                <label>ventes non d�but�s</label>
              </div>
              <div>
                <input type="checkbox"/>
                <label>ventes termin�s</label>
              </div>
            </div>
          </div>
       </div>
      </div>
      <button>Rechercher</button>
    </form>
  </section>
  <section class="container">
    <div class="grid_article">
      <div class="card_article">
        <img src="" alt="">
        <div>
          <h3>Titre de l'article</h3>
          <p>Prix : 210 points</p>
          <p>Fin de l'ench�re : 10/08/2018</p>
          <p>Vendeur : jojo44</p>
        </div>
      </div>
      <div class="card_article">
        <img src="" alt="">
        <div>
          <h3>Titre de l'article</h3>
          <p>Prix : 210 points</p>
          <p>Fin de l'ench�re : 10/08/2018</p>
          <p>Vendeur : jojo44</p>
        </div>
      </div>
    </div>
  </section>
</body>
</html>