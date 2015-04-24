package edu.stthomas.gps.familyrecipesystem.entity;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name = "ingredient")
public class IngredientImpl implements Ingredient {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	private int id;

	@Column
	private String name;

	@ManyToOne(targetEntity = IngredientOptionsImpl.class)
	private final Set<IngredientOptions> ingredientOptions = new HashSet<>();

	@Override
	public final int getId() {
		return this.id;
	}

	@Override
	public final void setId(final int id) {
		this.id = id;
	}

	@Override
	public final String getName() {
		return this.name;
	}

	@Override
	public final void setName(final String name) {
		this.name = name;
	}

	public void setIngredientOptions(final Collection<IngredientOptions> ingredientOptions) {
		this.ingredientOptions.clear();
		this.ingredientOptions.addAll(ingredientOptions);
	}

	public Set<IngredientOptions> getIngredientOptions() {
		return Collections.unmodifiableSet(this.ingredientOptions);
	}

	public void addIngredientOption(final IngredientOptions option) {
		this.ingredientOptions.add(option);
	}

	public void removeIngredientOption(final IngredientOptions option) {
		this.ingredientOptions.remove(option);
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
		final IngredientImpl other = (IngredientImpl) obj;
		if (this.id != other.id) {
			return false;
		}
		return true;
	}
}
