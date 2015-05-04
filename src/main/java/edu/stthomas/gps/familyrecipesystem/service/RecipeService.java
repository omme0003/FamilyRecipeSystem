package edu.stthomas.gps.familyrecipesystem.service;

import java.util.List;

import edu.stthomas.gps.familyrecipesystem.dao.RecipeDao;
import edu.stthomas.gps.familyrecipesystem.entity.Recipe;

public interface RecipeService extends AbstractService<RecipeDao> {

	public void update(final Recipe recipe);

	public void insertOrUpdate(final Recipe recipe);

	public List<Recipe> searchByKeyword(final String keyword);

}
