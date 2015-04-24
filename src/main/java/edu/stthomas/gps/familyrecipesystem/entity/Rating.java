package edu.stthomas.gps.familyrecipesystem.entity;

public interface Rating {
	public Member getMember();

	public void setMember(final Member member);

	public Recipe getRecipe();

	public void setRecipe(final Recipe recipe);

	public int getStars();

	public void setStars(final int stars);
}
