package edu.stthomas.gps.familyrecipesystem.dao;

import org.hibernate.Session;

import edu.stthomas.gps.familyrecipesystem.entity.Ingredient;
import edu.stthomas.gps.familyrecipesystem.entity.IngredientImpl;

public class IngredientDaoImpl extends AbstractDaoImpl<Ingredient> implements IngredientDao {

	@Override
	public Ingredient getByName(final String name) {
		final Session session = this.getSessionFactory().getCurrentSession();
		return (Ingredient) session.createQuery("FROM ingredient WHERE name = :name")
				.setParameter("name", name).uniqueResult();
	}

	@Override
	public Ingredient getById(final Integer id) {
		return (Ingredient) this.getSessionFactory().getCurrentSession().load(IngredientImpl.class, id);
	}
}
