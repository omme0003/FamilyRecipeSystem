package edu.stthomas.gps.familyrecipesystem.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.stthomas.gps.familyrecipesystem.AppSession;
import edu.stthomas.gps.familyrecipesystem.FamilyRecipeSystemApplication;
import edu.stthomas.gps.familyrecipesystem.dao.IngredientDao;
import edu.stthomas.gps.familyrecipesystem.dao.MemberDao;
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
	public void insertOrUpdate(final Recipe recipe) {
		final IngredientDao ingredientDao = FamilyRecipeSystemApplication.getContext().getBean("ingredientDao",
				IngredientDao.class);
		final MemberDao memberDao = FamilyRecipeSystemApplication.getContext().getBean("memberDao", MemberDao.class);
		final List<IngredientOptions> newIngredientOptions = new ArrayList<IngredientOptions>();
		for (final IngredientOptions option : recipe.getIngredientOptions())
		{
			final String ingredientName = option.getIngredient().getName();
			final Ingredient ingredient = ingredientDao.getByName(ingredientName);
			if (ingredient != null) {
				// option.setIngredient(ingredientDao.getById(ingredient.getId()));
				option.getIngredient().setId(ingredient.getId());
			}
			newIngredientOptions.add(option);
		}
		recipe.setIngredientOptions(newIngredientOptions);

		final Date current = new Date();
		recipe.setLastChanged(current);
		recipe.setManagedBy(AppSession.getInstance().getUser());
		if (recipe.getId() == null) {
			recipe.setCreated(current);
			this.getDao().insert(recipe);
		}
		this.getDao().merge(recipe);
	}

	@Override
	public List<Recipe> searchByKeyword(final String keyword) {
		return this.getDao().searchByKeyword(keyword);
	}

	@Override
	public Recipe getById(final Integer id) {
		return this.getDao().getById(id);
	}
}
