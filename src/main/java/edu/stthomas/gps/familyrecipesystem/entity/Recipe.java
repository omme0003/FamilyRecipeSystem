package edu.stthomas.gps.familyrecipesystem.entity;

import java.util.Collection;
import java.util.Date;
import java.util.List;

public interface Recipe extends Entity {

	public Integer getId();

	public void setId(final Integer id);

	public String getName();

	public void setName(final String name);

	public Date getCreated();

	public void setCreated(final Date created);

	public Date getLastChanged();

	public void setLastChanged(final Date lastChanged);

	public Member getManagedBy();

	public void setManagedBy(final Member managedBy);

	public List<Comment> getComments();

	public void setComments(final Collection<Comment> comments);

	public void addComment(final Comment comment);

	public void addComment(String text, final Member member);

	public void removeComment(final Comment comment);

	public String getDescription();

	public void setDescription(String description);

	public void setIngredientOptions(Collection<IngredientOptions> ingredients);

	public List<IngredientOptions> getIngredientOptions();

	public void addIngredientOptions(final IngredientOptions ingredients);

	public void addIngredient(final float quanity, final Unit unit, final String ingredientName);

}
