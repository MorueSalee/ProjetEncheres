package fr.formation.enchere.bll;

import fr.formation.enchere.bo.Utilisateur;

public interface UtilisateurManager {
	public void addUtilisateur(Utilisateur utilisateur);
	public Utilisateur check(String login, String password);
}