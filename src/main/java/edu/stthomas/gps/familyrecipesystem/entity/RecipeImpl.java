package edu.stthomas.gps.familyrecipesystem.entity;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity(name = "recipe")
@Table(name = "recipe")
public class RecipeImpl implements Recipe {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	private Integer id;

	@Column
	private String name;

	@Column
	private String description;

	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date created;

	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastChanged;

	@ManyToOne(targetEntity = MemberImpl.class)
	@LazyCollection(LazyCollectionOption.FALSE)
	private Member managedBy;

	@OneToMany(targetEntity = CommentImpl.class, mappedBy = "recipe", cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private final List<Comment> comments;

	@OneToMany(targetEntity = IngredientOptionsImpl.class, mappedBy = "recipe", cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private final List<IngredientOptions> ingredientOptions;

	public RecipeImpl() {
		this.comments = new LinkedList<>();
		this.ingredientOptions = new LinkedList<>();
	}

	public RecipeImpl(final String name) {
		this();
		this.setName(name);
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
	public final String getName() {
		return this.name;
	}

	@Override
	public final void setName(final String name) {
		this.name = name;
	}

	@Override
	public final String getDescription() {
		return this.description;
	}

	@Override
	public final void setDescription(final String description) {
		this.description = description;
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
	public final Date getLastChanged() {
		return this.lastChanged;
	}

	@Override
	public final void setLastChanged(final Date lastChanged) {
		this.lastChanged = lastChanged;
	}

	@Override
	public final Member getManagedBy() {
		return this.managedBy;
	}

	@Override
	public final void setManagedBy(final Member managedBy) {
		this.managedBy = managedBy;
	}

	@Override
	public final List<Comment> getComments() {
		return Collections.unmodifiableList(this.comments);
	}

	@Override
	public final void setComments(final Collection<Comment> comments) {
		this.comments.clear();
		this.comments.addAll(comments);
	}

	@Override
	public void addComment(final Comment comment) {
		this.comments.add(comment);
	}

	@Override
	public void removeComment(final Comment comment) {
		this.comments.remove(comment);
	}

	@Override
	public final List<IngredientOptions> getIngredientOptions() {
		return Collections.unmodifiableList(this.ingredientOptions);
	}

	@Override
	public final void setIngredientOptions(final Collection<IngredientOptions> ingredients) {
		this.ingredientOptions.clear();
		this.ingredientOptions.addAll(ingredients);
	}

	@Override
	public void addIngredientOptions(final IngredientOptions ingredients) {
		this.ingredientOptions.add(ingredients);
	}

	@Override
	public void addIngredient(final float quanity, final Unit unit, final String ingredientName) {
		this.addIngredientOptions(new IngredientOptionsImpl(quanity, unit, ingredientName, this));
	}

	@Override
	public String toString() {
		final Member member = this.managedBy;
		return member.getFirstName() + " " + member.getLastName() + "'s " + this.name;
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
		final RecipeImpl other = (RecipeImpl) obj;
		if (this.id != other.id) {
			return false;
		}
		return true;
	}

}
