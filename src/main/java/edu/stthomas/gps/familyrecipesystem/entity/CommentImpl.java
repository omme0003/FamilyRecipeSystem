package edu.stthomas.gps.familyrecipesystem.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity(name = "comment")
public class CommentImpl implements Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	private int id;

	@OneToOne(targetEntity = MemberImpl.class, cascade = CascadeType.ALL)
	private Member member;

	@OneToOne(targetEntity = RecipeImpl.class, cascade = CascadeType.ALL)
	private Recipe recipe;

	@Column(name = "comment_text", length = 1024)
	private String text;

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
	public void setMember(final Member member) {
		this.member = member;
	}

	@Override
	public final Recipe getRecipe() {
		return this.recipe;
	}

	@Override
	public void setRecipe(final Recipe recipe) {
		this.recipe = recipe;
	}

	@Override
	public String getText() {
		return this.text;
	}

	@Override
	public void setText(final String text) {
		this.text = text;
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
		final CommentImpl other = (CommentImpl) obj;
		if (this.id != other.id) {
			return false;
		}
		return true;
	}

}
