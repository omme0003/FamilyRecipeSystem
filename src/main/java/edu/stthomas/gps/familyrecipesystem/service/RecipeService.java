package edu.stthomas.gps.familyrecipesystem.service;

import java.util.List;

import edu.stthomas.gps.familyrecipesystem.dao.AbstractDao;
import edu.stthomas.gps.familyrecipesystem.entity.Recipe;

public interface RecipeService extends AbstractService<AbstractDao<Recipe>> {

	public void create(final Recipe recipe);

	public List<Recipe> searchByKeyword(final String keyword);

}
