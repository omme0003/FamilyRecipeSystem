package edu.stthomas.gps.familyrecipesystem.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "comment")
public class CommentImpl implements Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	private Integer id;

	@ManyToOne(targetEntity = MemberImpl.class)
	private Member member;

	@ManyToOne(targetEntity = RecipeImpl.class)
	private Recipe recipe;

	@Column(name = "comment_text", length = 1024)
	private String text;

	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date created;

	public CommentImpl() {
	}

	public CommentImpl(final String text, final Member member, final Recipe recipe) {
		this.setText(text);
		this.setMember(member);
		this.setRecipe(recipe);
		this.setCreated(new Date());
	}

	@Override
	public Integer getId() {
		return this.id;
	}

	@Override
	public void setId(final Integer id) {
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
	public final Date getCreated() {
		return this.created;
	}

	@Override
	public final void setCreated(final Date created) {
		this.created = created;
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
