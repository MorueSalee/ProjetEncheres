package fr.formation.enchere.bll;

import fr.formation.enchere.bo.Utilisateur;

public interface UtilisateurManager {
	public void addUtilisateur(Utilisateur utilisateur);
	public Utilisateur check(String login, String password);
	public Utilisateur findById(Integer id);
	public void update(Utilisateur utilisateur);
	public void delete(Integer id);
}
