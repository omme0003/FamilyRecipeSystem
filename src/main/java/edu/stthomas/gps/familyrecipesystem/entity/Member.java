package edu.stthomas.gps.familyrecipesystem.entity;

import java.util.Collection;
import java.util.List;

public interface Member extends Entity {

	public Integer getId();

	public void setId(final Integer id);

	public String getUserName();

	public void setUserName(final String userName);

	public String getPassword();

	public void setPassword(final String password);

	public String getFirstName();

	public void setFirstName(final String firstName);

	public String getLastName();

	public void setLastName(final String lastName);

	public List<Recipe> getRecipes();

	public void setRecipes(final Collection<Recipe> recipes);

	public void addRecipe(final Recipe recipe);

	public void removeRecipe(final Recipe recipe);

	public List<Family> getFamilies();

	public void setFamilies(final Collection<Family> families);

	public void addFamily(final Family family);

	public List<Comment> getComments();

	public void setComments(final Collection<Comment> comments);

	public void addComment(final Comment comment);

	public void removeComment(final Comment comment);

	public boolean validateRequiredFields();

}
