package edu.stthomas.gps.familyrecipesystem.entity;

public interface IngredientOptions {
	public int getQuantity();

	public void setQuantity(final int quantity);

	public Unit getUnit();

	public void setUnit(final Unit unit);

	public Ingredient getIngredient();

	public void setIngredient(final Ingredient ingredient);

	public Recipe getRecipe();

	public void setRecipe(final Recipe recipe);
}
