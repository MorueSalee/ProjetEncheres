<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<nav>
    <h1><a href="${pageContext.request.contextPath}/EnchereServlet">ENI - Enchere</a></h1>
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
              <a href="${pageContext.request.contextPath}/EnchereServlet">Enchères</a>
          </li>
          <li>
              <a href="${pageContext.request.contextPath}/NewSaleServlet">Vendre un article</a>
          </li>
          <li>
              <a href="${pageContext.request.contextPath}/ProfileServlet">Mon profil</a>
          </li>
          <li>
              <a href="${pageContext.request.contextPath}/LogoutServlet">Déconnexion</a>
          </li>
      </ul>
</nav>
