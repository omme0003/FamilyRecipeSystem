package edu.stthomas.gps.familyrecipesystem.service;

import java.util.ArrayList;
import java.util.List;

import edu.stthomas.gps.familyrecipesystem.FamilyRecipeSystemApplication;
import edu.stthomas.gps.familyrecipesystem.dao.IngredientDao;
import edu.stthomas.gps.familyrecipesystem.dao.RecipeDao;
import edu.stthomas.gps.familyrecipesystem.entity.Ingredient;
import edu.stthomas.gps.familyrecipesystem.entity.IngredientOptions;
import edu.stthomas.gps.familyrecipesystem.entity.Recipe;

public class RecipeServiceImpl extends AbstractServiceImpl<RecipeDao> implements RecipeService {

	@Override
	public void update(final Recipe recipe) {
		this.getDao().update(recipe);
	}

	@Override
	public void create(final Recipe recipe) {
		final IngredientDao ingredientDao = FamilyRecipeSystemApplication.getContext().getBean("ingredientDao", IngredientDao.class);
		final List<IngredientOptions> newIngredientOptions = new ArrayList<IngredientOptions>();
		for (final IngredientOptions option : recipe.getIngredientOptions()) {
			final String ingredientName = option.getIngredient().getName();
			final Ingredient ingredient = ingredientDao.getByName(ingredientName);
			if (ingredient != null) {
				option.getIngredient().setId(ingredient.getId());
			}
			newIngredientOptions.add(option);
		}
		recipe.setIngredientOptions(newIngredientOptions);

		this.getDao().saveOrUpdate(recipe);
	}

	@Override
	public List<Recipe> searchByKeyword(final String keyword) {
		return this.getDao().searchByKeyword(keyword);
	}
}
