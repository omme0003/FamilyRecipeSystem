package edu.stthomas.gps.familyrecipesystem.entity;

public interface Comment {

	public int getId();

	public void setId(final int id);

	public Member getMember();

	public void setMember(final Member member);

	public Recipe getRecipe();

	public void setRecipe(final Recipe recipe);

	public String getText();

	public void setText(final String text);
}
