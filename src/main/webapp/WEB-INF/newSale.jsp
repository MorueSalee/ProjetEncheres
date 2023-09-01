<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/newSale.css">
    <link rel="stylesheet" href="css/all.css" />
    
    <title>Document</title>
</head>
<body>
      <jsp:include page="nav.jsp"/>
      <h2>Nouvelle vente</h2>
    <section id="new_sale" class="container">
        <form action="NewSaleServlet"  method="post">
            <img src="" alt=""/>
            <div>
                <div>
                    <label>Article :</label>
                    <input type="text" name="nomArticle"/>
                </div>
                <div>
                    <label>Description :</label>
                    <textarea type="description"></textarea>
                </div>
                <div>
                    <label>Categories :</label>
                    <select>
                        <option>0</option>
                    </select>
                </div>
                <div>
                    <label>Photo de l'article :</label>
                    <input type="file">
                </div>
                <div>
                    <label>Mise à prix :</label>
                    <input type="number" name="prixInitial">
                </div>
                <div>
                    <label>Début de l'enchère :</label>
                    <input type="date" name="dateDebutEncheres"/>

                </div>
                <div>
                    <label>Fin de l'enchère :</label>
                    <input type="date" name="dateFinEncheres"/>
                </div>
                <div class="retrait">
                    <h4>Retrait</h4>
                    <div>
                        <label>Rue :</label>
                        <input type="text"/>
                    </div>
                    <div>
                        <label>Code postale :</label>
                        <input type="text"/>
                    </div>
                    <div>
                        <label>Ville :</label>
                        <input type="text"/>
                    </div>
                </div>
                <div>
                    <input type="submit" value="Enregistrer">
                    <button>Annuler</button>
                    <button>Annuler la vente</button>
                </div>
            </div>
        </form>
    </section>
</body>
</html>