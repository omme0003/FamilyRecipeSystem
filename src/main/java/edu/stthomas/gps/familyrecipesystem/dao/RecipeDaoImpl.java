package edu.stthomas.gps.familyrecipesystem.dao;

import java.util.List;

import org.hibernate.Session;

import edu.stthomas.gps.familyrecipesystem.entity.Recipe;

public class RecipeDaoImpl extends AbstractDaoImpl<Recipe> implements RecipeDao {

	@Override
	public List<Recipe> searchByKeyword(final String keyword) {
		final Session session = this.getSessionFactory().getCurrentSession();
		final String search = "%" + keyword + "%";
		return session.createQuery("FROM recipe WHERE name LIKE :name OR description LIKE :desc ORDER BY name").setParameter("name", search)
				.setParameter("desc", search).list();
	}
}
