package edu.stthomas.gps.familyrecipesystem.service;

import java.util.List;

import edu.stthomas.gps.familyrecipesystem.dao.AbstractDao;
import edu.stthomas.gps.familyrecipesystem.entity.Recipe;

public class RecipeServiceImpl extends AbstractServiceImpl<AbstractDao<Recipe>> implements RecipeService {

	@Override
	public void create(final Recipe recipe) {
		this.getDao().insert(recipe);
	}

	@Override
	public List<Recipe> searchByKeyword(final String keyword) {
		// return this.getDao().searchByKeyword(keyword);
		return null;
	}
}
