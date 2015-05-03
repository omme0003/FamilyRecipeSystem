package edu.stthomas.gps.familyrecipesystem.entity;

import java.util.Date;

public interface Comment extends Entity {

	public int getId();

	public void setId(final int id);

	public Member getMember();

	public void setMember(final Member member);

	public Recipe getRecipe();

	public void setRecipe(final Recipe recipe);

	public String getText();

	public void setText(final String text);

	public Date getCreated();

	public void setCreated(final Date created);
}
