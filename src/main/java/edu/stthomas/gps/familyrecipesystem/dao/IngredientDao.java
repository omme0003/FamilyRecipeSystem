package edu.stthomas.gps.familyrecipesystem.dao;

import edu.stthomas.gps.familyrecipesystem.entity.Ingredient;

public interface IngredientDao extends AbstractDao<Ingredient> {

	public Ingredient getByName(final String name);

}
