package edu.stthomas.gps.familyrecipesystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name = "rating")
public class RatingImpl implements Rating {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	private int id;

	@ManyToOne(targetEntity = MemberImpl.class)
	private Member member;

	@ManyToOne(targetEntity = RecipeImpl.class)
	private Recipe recipe;

	@Column
	private int stars;

	@Override
	public int getId() {
		return this.id;
	}

	@Override
	public void setId(final int id) {
		this.id = id;
	}

	@Override
	public final Member getMember() {
		return this.member;
	}

	@Override
	public final void setMember(final Member member) {
		this.member = member;
	}

	@Override
	public final Recipe getRecipe() {
		return this.recipe;
	}

	@Override
	public final void setRecipe(final Recipe recipe) {
		this.recipe = recipe;
	}

	@Override
	public final int getStars() {
		return this.stars;
	}

	@Override
	public final void setStars(final int stars) {
		if ((stars < 1) || (stars > 5)) {
			throw new IllegalArgumentException("Number of stars has to be an integer between 1 and 5");
		}
		this.stars = stars;
	}
}
