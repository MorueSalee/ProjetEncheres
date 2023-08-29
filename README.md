# ProjetEncheres

-- Insert test values for CATEGORIES
INSERT INTO CATEGORIES (libelle) VALUES
    ('Electronics'),
    ('Clothing'),
    ('Furniture');

-- Insert test values for UTILISATEURS
INSERT INTO UTILISATEURS (pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) VALUES
    ('user1', 'Doe', 'John', 'john@example.com', '123-456-7890', '123 Main St', '12345', 'Cityville', 'password1', 100, 0),
    ('user2', 'Smith', 'Jane', 'jane@example.com', '987-654-3210', '456 Elm St', '54321', 'Towntown', 'password2', 150, 0);

-- Insert test values for ARTICLES_VENDUS
INSERT INTO ARTICLES_VENDUS (nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, no_utilisateur, no_categorie) VALUES
    ('Smartphone', 'Brand new smartphone', '2023-08-01', '2023-08-10', 500, 1, 1),
    ('T-shirt', 'Blue cotton T-shirt', '2023-08-05', '2023-08-15', 20, 2, 2);

-- Insert test values for RETRAITS
INSERT INTO RETRAITS (no_article, rue, code_postal, ville) VALUES
    (1, '123 Main St', '12345', 'Cityville'),
    (2, '456 Elm St', '54321', 'Towntown');

-- Insert test values for ENCHERES
INSERT INTO ENCHERES (no_utilisateur, no_article, date_enchere, montant_enchere) VALUES
    (1, 1, '2023-08-05 12:00:00', 550),
    (2, 1, '2023-08-08 10:00:00', 600);

-- Commit the changes
COMMIT;
