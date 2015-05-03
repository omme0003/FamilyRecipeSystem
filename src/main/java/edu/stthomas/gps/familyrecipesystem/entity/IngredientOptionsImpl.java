package edu.stthomas.gps.familyrecipesystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity(name = "IngredientOptions")
public class IngredientOptionsImpl implements IngredientOptions {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	private int id;

	@Column
	private float quantity;

	@Enumerated(EnumType.STRING)
	@Column
	private Unit unit;

	@ManyToOne(targetEntity = IngredientImpl.class)
	@LazyCollection(LazyCollectionOption.FALSE)
	private Ingredient ingredient;

	@ManyToOne(targetEntity = RecipeImpl.class)
	private Recipe recipe;

	@Override
	public int getId() {
		return this.id;
	}

	@Override
	public void setId(final int id) {
		this.id = id;
	}

	@Override
	public final float getQuantity() {
		return this.quantity;
	}

	@Override
	public String getQuantityFormatted() {
		return String.format("%.02f", this.quantity);
	}

	@Override
	public final void setQuantity(final float quantity) {
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
