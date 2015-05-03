package edu.stthomas.gps.familyrecipesystem.dao;

import java.util.List;

import org.hibernate.Session;

import edu.stthomas.gps.familyrecipesystem.entity.Recipe;

public class RecipeDaoImpl extends AbstractDaoImpl<Recipe> implements RecipeDao {

	@Override
	public List<Recipe> searchByKeyword(final String keyword) {
		final Session session = this.getSessionFactory().getCurrentSession();
		return session.createQuery("FROM recipe WHERE name LIKE '%?%' OR description LIKE '%?%' ORDER BY name").setParameter(0, keyword)
				.setParameter(1, keyword).list();
	}
}
