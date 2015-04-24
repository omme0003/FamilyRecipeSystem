package edu.stthomas.gps.familyrecipesystem.entity;

public class IngredientOptionsImpl implements IngredientOptions {
	private int quantity;
	private Unit unit;
	private Ingredient ingredient;
	private Recipe recipe;

	@Override
	public final int getQuantity() {
		return this.quantity;
	}

	@Override
	public final void setQuantity(final int quantity) {
		this.quantity = quantity;
	}

	@Override
	public final Unit getUnit() {
		return this.unit;
	}

	@Override
	public final void setUnit(final Unit unit) {
		this.unit = unit;
	}

	@Override
	public final Ingredient getIngredient() {
		return this.ingredient;
	}

	@Override
	public final void setIngredient(final Ingredient ingredient) {
		this.ingredient = ingredient;
	}

	@Override
	public final Recipe getRecipe() {
		return this.recipe;
	}

	@Override
	public final void setRecipe(final Recipe recipe) {
		this.recipe = recipe;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((this.ingredient == null) ? 0 : this.ingredient.hashCode());
		result = (prime * result) + ((this.recipe == null) ? 0 : this.recipe.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		final IngredientOptionsImpl other = (IngredientOptionsImpl) obj;
		if (this.ingredient == null) {
			if (other.ingredient != null) {
				return false;
			}
		} else if (!this.ingredient.equals(other.ingredient)) {
			return false;
		}
		if (this.recipe == null) {
			if (other.recipe != null) {
				return false;
			}
		} else if (!this.recipe.equals(other.recipe)) {
			return false;
		}
		return true;
	}

}
