package edu.stthomas.gps.familyrecipesystem.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity(name = "ingredient")
public class IngredientImpl implements Ingredient {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	private Integer id;

	@Column(nullable = false)
	private String name;
	
	@OneToMany(targetEntity = IngredientOptionsImpl.class, mappedBy = "ingredient")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<IngredientOptions> ingredientOptions;

	public IngredientImpl() {
		this.ingredientOptions = new ArrayList<IngredientOptions>();
	}

	public IngredientImpl(final String name) {
		this();
		this.setName(name);
	}

	@Override
	public final Integer getId() {
		return this.id;
	}

	@Override
	public final void setId(final Integer id) {
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

	@Override
	public final List<IngredientOptions> getIngredientOptions() {
		return ingredientOptions;
	}

	@Override
	public final void setIngredientOptions(List<IngredientOptions> ingredientOptions) {
		this.ingredientOptions = ingredientOptions;
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
