package edu.stthomas.gps.familyrecipesystem.entity;

public class RatingImpl {
	private Member member;
	private Recipe recipe;
	private int stars;

	public final Member getMember() {
		return this.member;
	}

	public final void setMember(final Member member) {
		this.member = member;
	}

	public final Recipe getRecipe() {
		return this.recipe;
	}

	public final void setRecipe(final Recipe recipe) {
		this.recipe = recipe;
	}

	public final int getStars() {
		return this.stars;
	}

	public final void setStars(final int stars) {
		if ((stars < 1) || (stars > 5)) {
			throw new IllegalArgumentException("Number of stars has to be an integer between 1 and 5");
		}
		this.stars = stars;
	}
}
