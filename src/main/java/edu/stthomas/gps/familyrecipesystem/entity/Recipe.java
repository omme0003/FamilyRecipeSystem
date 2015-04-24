package edu.stthomas.gps.familyrecipesystem.entity;

import java.util.Collection;
import java.util.Date;
import java.util.List;

public interface Recipe {

	public int getId();

	public void setId(final int id);

	public String getName();

	public void setName(final String name);

	public Date getCreated();

	public void setCreated(final Date created);

	public Date getLastChanged();

	public void setLastChanged(final Date lastChanged);

	public Member getManagedBy();

	public void setManagedBy(final Member managedBy);

	public List<Rating> getRatings();

	public void setRatings(final Collection<Rating> ratings);

	public void addRating(final Rating rating);

	public void removeRating(final Rating rating);

	public List<Comment> getComments();

	public void setComments(final Collection<Comment> comments);

	public void addComment(final Comment comment);

	public void removeComment(final Comment comment);

	public List<Ingredient> getIngredients();

	public void setIngredients(final Collection<Ingredient> ingredients);

	public List<String> getTags();

	public void setTags(final Collection<String> tags);

	public void addTag(final String tag);

	public void removeTag(final String tag);

}
