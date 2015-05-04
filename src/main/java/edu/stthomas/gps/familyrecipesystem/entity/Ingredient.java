package edu.stthomas.gps.familyrecipesystem.entity;

import java.util.List;


public interface Ingredient extends Entity {

	public Integer getId();

	public void setId(final Integer id);

	public String getName();

	public void setName(final String name);

	public List<IngredientOptions> getIngredientOptions();

	public void setIngredientOptions(List<IngredientOptions> ingredientOptions);
}
