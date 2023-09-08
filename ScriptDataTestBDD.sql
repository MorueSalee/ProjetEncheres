-- Insert 5 CATEGORIES
INSERT INTO CATEGORIES (libelle) VALUES
('Toutes'),
('Pistolets'),
('Vêtements & Accessoires'),
('Lunettes'),
('Voitures');

-- Insert 20 UTILISATEURS
INSERT INTO UTILISATEURS (pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) VALUES
('User1', 'LastName1', 'FirstName1', 'user1@example.com', '123456789', 'Address1', '12345', 'City1', 'password1', 100, 0),
('User2', 'LastName2', 'FirstName2', 'user2@example.com', '987654321', 'Address2', '54321', 'City2', 'password2', 200, 0),
('User3', 'LastName3', 'FirstName3', 'user3@example.com', '555555555', 'Address3', '11111', 'City3', 'password3', 300, 0),
('User4', 'LastName4', 'FirstName4', 'user4@example.com', '444444444', 'Address4', '22222', 'City4', 'password4', 400, 0),
('User5', 'LastName5', 'FirstName5', 'user5@example.com', '777777777', 'Address5', '33333', 'City5', 'password5', 500, 0),
-- Add more users as needed

-- Insert 30 ARTICLES_VENDUS
INSERT INTO ARTICLES_VENDUS (nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie, etat_vente) VALUES
('Luettes teintées', 'Description 1', '2023-09-01', '2023-09-10', 100, 150, 1, 1, 'En cours'),
('Magnum', 'Description 2', '2023-09-02', '2023-09-11', 200, 200, 2, 2, 'En cours'),
('Ford Mustang', 'Description 3', '2023-09-03', '2023-09-12', 150, 150, 3, 1, 'En cours'),
('Bouc postiche', 'Description 4', '2023-09-04', '2023-09-13', 300, 300, 4, 3, 'En cours'),
('Item 1', 'Description 5', '2023-09-05', '2023-09-14', 250, 250, 5, 4, 'Enchères terminées'),
('Item 2', 'Description 5', '2023-09-05', '2023-09-14', 250, 250, 1, 5, 'Retrait effectué'),
('Item 3', 'Description 5', '2023-09-05', '2023-09-14', 250, 250, 2, 1, 'Créée'),
('Item 4', 'Description 5', '2023-09-05', '2023-09-14', 250, 250, 3, 2, 'Enchères terminées'),
('Item 5', 'Description 5', '2023-09-05', '2023-09-14', 250, 250, 4, 3, 'Retrait effectué'),
('Item 6', 'Description 5', '2023-09-05', '2023-09-14', 250, 250, 5, 4, 'En cours'),
('Item 7', 'Description 5', '2023-09-05', '2023-09-14', 250, 250, 1, 5, 'En cours'),
('Item 8', 'Description 5', '2023-09-05', '2023-09-14', 250, 250, 2, 1, 'Enchères terminées'),
('Item 9', 'Description 5', '2023-09-05', '2023-09-14', 250, 250, 3, 2, 'Créée'),
-- Add more items as needed

-- Insert 10 RETRAITS
INSERT INTO RETRAITS (no_article, rue, code_postal, ville) VALUES
(1, 'Address1', '12345', 'City1'),
(2, 'Address2', '54321', 'City2'),
(3, 'Address3', '11111', 'City3'),
(4, 'Address4', '22222', 'City4'),
(5, 'Address5', '33333', 'City5'),
-- Add more retraits as needed

-- Insert 5 ENCHERES
INSERT INTO ENCHERES (no_utilisateur, no_article, date_enchere, montant_enchere) VALUES
(1, 1, '2023-09-02 12:00:00', 120),
(2, 1, '2023-09-02 12:01:00', 130),
(3, 2, '2023-09-02 12:02:00', 220),
(4, 2, '2023-09-02 12:03:00', 240),
(5, 3, '2023-09-02 12:04:00', 310);
-- Add more enchères as needed
