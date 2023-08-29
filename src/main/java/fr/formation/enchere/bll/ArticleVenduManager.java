package fr.formation.enchere.bll;

import java.util.List;

import org.apache.catalina.filters.AddDefaultCharsetFilter;

import fr.formation.enchere.bo.ArticleVendu;

public interface ArticleVenduManager {
	public void add(ArticleVendu article);
	public List<ArticleVendu> getAll();
	public void update(ArticleVendu article);
}
