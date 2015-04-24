package edu.stthomas.gps.familyrecipesystem.entity;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class RecipeImpl implements Recipe {
	private int id;
	private String name;
	private Date created;
	private Date lastChanged;
	private Member managedBy;

	private final List<Comment> comments;
	private final List<Ingredient> ingredients;
	private final List<String> tags;
	private final List<Rating> ratings;

	public RecipeImpl() {
		this.comments = new LinkedList<>();
		this.ingredients = new LinkedList<>();
		this.tags = new LinkedList<>();
		this.ratings = new LinkedList<>();
	}

	@Override
	public int getId() {
		return this.id;
	}

	@Override
	public void setId(final int id) {
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
	public final Date getCreated() {
		return this.created;
	}

	@Override
	public final void setCreated(final Date created) {
		this.created = created;
	}

	@Override
	public final Date getLastChanged() {
		return this.lastChanged;
	}

	@Override
	public final void setLastChanged(final Date lastChanged) {
		this.lastChanged = lastChanged;
	}

	@Override
	public final Member getManagedBy() {
		return this.managedBy;
	}

	@Override
	public final void setManagedBy(final Member managedBy) {
		this.managedBy = managedBy;
	}

	@Override
	public List<Rating> getRatings() {
		return Collections.unmodifiableList(this.ratings);
	}

	@Override
	public void setRatings(final Collection<Rating> ratings) {
		this.ratings.clear();
		this.ratings.addAll(ratings);
	}

	@Override
	public void addRating(final Rating rating) {
		this.ratings.add(rating);
	}

	@Override
	public void removeRating(final Rating rating) {
		this.ratings.remove(rating);
	}

	@Override
	public final List<Comment> getComments() {
		return Collections.unmodifiableList(this.comments);
	}

	@Override
	public final void setComments(final Collection<Comment> comments) {
		this.comments.clear();
		this.comments.addAll(comments);
	}

	@Override
	public void addComment(final Comment comment) {
		this.comments.add(comment);
	}

	@Override
	public void removeComment(final Comment comment) {
		this.comments.remove(comment);
	}

	@Override
	public final List<Ingredient> getIngredients() {
		return Collections.unmodifiableList(this.ingredients);
	}

	@Override
	public final void setIngredients(final Collection<Ingredient> ingredients) {
		this.ingredients.clear();
		this.ingredients.addAll(ingredients);
	}

	@Override
	public final List<String> getTags() {
		return Collections.unmodifiableList(this.tags);
	}

	@Override
	public final void setTags(final Collection<String> tags) {
		this.tags.clear();
		this.tags.addAll(tags);
	}

	@Override
	public void addTag(final String tag) {
		this.tags.add(tag);
	}

	@Override
	public void removeTag(final String tag) {
		this.tags.remove(tag);
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
		final RecipeImpl other = (RecipeImpl) obj;
		if (this.id != other.id) {
			return false;
		}
		return true;
	}

}
