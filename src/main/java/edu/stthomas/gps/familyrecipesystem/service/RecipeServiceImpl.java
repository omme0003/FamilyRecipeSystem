package edu.stthomas.gps.familyrecipesystem.service;

import java.util.List;

import edu.stthomas.gps.familyrecipesystem.dao.RecipeDao;
import edu.stthomas.gps.familyrecipesystem.entity.Recipe;

public class RecipeServiceImpl extends AbstractServiceImpl<RecipeDao> implements RecipeService {

	@Override
	public void update(final Recipe recipe) {
		this.getDao().update(recipe);
	}

	@Override
	public void create(final Recipe recipe) {
		// final IngredientDao ingredientDao =
		// FamilyRecipeSystemApplication.getContext().getBean("ingredientDao",
		// IngredientDaoImpl.class);
		// final List<IngredientOptions> newIngredientOptions = new
		// ArrayList<IngredientOptions>();
		// for (final IngredientOptions option : recipe.getIngredientOptions())
		// {
		// final String ingredientName = option.getIngredient().getName();
		// final Ingredient ingredient =
		// ingredientDao.getByName(ingredientName);
		// option.;
		// }
	}

	@Override
	public List<Recipe> searchByKeyword(final String keyword) {
		return this.getDao().searchByKeyword(keyword);
	}
}
