package edu.stthomas.gps.familyrecipesystem.dao;

import org.hibernate.Session;

import edu.stthomas.gps.familyrecipesystem.entity.Ingredient;

public class IngredientDaoImpl extends AbstractDaoImpl<Ingredient> implements IngredientDao {

	@Override
	public Ingredient getByName(final String name) {
		final Session session = this.getSessionFactory().getCurrentSession();
		return (Ingredient) session.createQuery("FROM ingredient WHERE name = :name")
				.setParameter("name", name).uniqueResult();
	}
}
