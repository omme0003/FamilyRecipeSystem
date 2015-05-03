package edu.stthomas.gps.familyrecipesystem.entity;

public interface IngredientOptions extends Entity {
	public int getId();

	public void setId(final int id);

	public float getQuantity();

	public String getQuantityFormatted();

	public void setQuantity(final float quantity);

	public Unit getUnit();

	public void setUnit(final Unit unit);

	public Ingredient getIngredient();

	public void setIngredient(final Ingredient ingredient);

	public Recipe getRecipe();

	public void setRecipe(final Recipe recipe);
}
