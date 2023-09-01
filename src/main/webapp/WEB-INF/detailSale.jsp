<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/detailSale.css">
    <link rel="stylesheet" href="css/all.css" />
    
    <title>Document</title>
</head>
<body>
    <jsp:include page="nav.jsp"/>
    <h2>Détail vente</h2>
    <section id="detail_sale" class="container">
        <img src="" alt="">
        <div class="body_detail">
            <p>PC</p>
            <div>
                <p>Description</p>
                <p>
                    Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi elementum scelerisque convallis. Curabitur purus eros, tristique vel mauris sed, auctor commodo sem. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Nullam placerat, risus non luctus sodales, augue mauris venenatis erat, ac interdum dolor elit vel eros. Duis arcu diam, ullamcorper sit amet libero et, imperdiet maximus lectus.
                </p>
            </div>
            <div>
                <p>Catégorie :</p>
                <p>Informatique</p>
            </div>
            <div>
                <p>Meilleure offre : </p>
                <p>210 pts par bob</p>
            </div>
            <div>
                <p>Fin de l'enchère : </p>
                <p>28/08/2008</p>
            </div>
            <div>
                <p>Retrait : </p>
                <p>10 allée des alouettes, 44800 Saint Herblain</p>
            </div>
            <div>
                <p>Vendeur : </p>
                <p>jojo44</p>
            </div>
            <form>
                <p>Ma proposition : </p>
                <input type="number">
                <button>Enchérir</button>
            </form>
        </div>
    </section>
</body>
</html>