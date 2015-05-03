package edu.stthomas.gps.familyrecipesystem.dao;

import java.util.List;

import org.hibernate.Session;

import edu.stthomas.gps.familyrecipesystem.entity.Ingredient;

public class IngredientDaoImpl extends AbstractDaoImpl<Ingredient> implements IngredientDao {

	@Override
	public Ingredient getByName(final String name) {
		final Session session = this.getSessionFactory().getCurrentSession();
		final List<Ingredient> ingredients = session.createQuery("FROM ingredient WHERE name = :name").setParameter("name", name).list();
		if (ingredients.isEmpty()) {
			return null;
		} else {
			return ingredients.get(0);
		}
	}
}
