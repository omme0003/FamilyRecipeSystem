package edu.stthomas.gps.familyrecipesystem.entity;

import javax.persistence.CascadeType;
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
	private Integer id;

	@Column
	private float quantity;

	@Enumerated(EnumType.STRING)
	@Column
	private Unit unit;

	@ManyToOne(targetEntity = IngredientImpl.class, cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private Ingredient ingredient;

	@ManyToOne(targetEntity = RecipeImpl.class, cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private Recipe recipe;

	public IngredientOptionsImpl() {
	}

	public IngredientOptionsImpl(final float quanity, final Unit unit, final Ingredient ingredient, final Recipe recipe) {
		this.setIngredient(ingredient);
		this.setQuantity(quanity);
		this.setRecipe(recipe);
		this.setUnit(unit);
	}

	public IngredientOptionsImpl(final float quanity, final Unit unit, final String ingredientName, final Recipe recipe) {
		this.setIngredient(new IngredientImpl(ingredientName));
		this.setQuantity(quanity);
		this.setRecipe(recipe);
		this.setUnit(unit);
	}

	@Override
	public Integer getId() {
		return this.id;
	}

	@Override
	public void setId(final Integer id) {
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
	public String toString() {
		return String.format("%.01f %s %s(s)", this.quantity, this.unit.getNameShort(), this.ingredient.getName());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + this.id;
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
		if (this.id != other.id) {
			return false;
		}
		return true;
	}

}
