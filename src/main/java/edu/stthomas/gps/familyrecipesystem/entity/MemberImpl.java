package edu.stthomas.gps.familyrecipesystem.entity;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity(name = "member")
public class MemberImpl implements Member {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	private Integer id;

	@Column(unique = true, nullable = false)
	private String userName;

	@Column(nullable = false)
	private String password;

	@Column(nullable = false)
	private String firstName;

	@Column(nullable = false)
	private String lastName;

	@OneToMany(targetEntity = RecipeImpl.class, cascade = CascadeType.ALL, mappedBy = "managedBy")
	@LazyCollection(LazyCollectionOption.FALSE)
	private final List<Recipe> recipes;

	@ManyToMany(targetEntity = FamilyImpl.class, cascade = CascadeType.ALL)
	@JoinTable(name = "member_family", joinColumns = @JoinColumn(name = "member_id"), inverseJoinColumns = @JoinColumn(name = "family_id"))
	@LazyCollection(LazyCollectionOption.FALSE)
	private final List<Family> families;

	@OneToMany(targetEntity = CommentImpl.class, cascade = CascadeType.ALL, mappedBy = "member")
	@LazyCollection(LazyCollectionOption.FALSE)
	private final List<Comment> comments;

	public MemberImpl() {
		this.recipes = new LinkedList<>();
		this.families = new LinkedList<>();
		this.comments = new LinkedList<>();
	}

	@Override
	public final Integer getId() {
		return this.id;
	}

	@Override
	public final void setId(final Integer id) {
		this.id = id;
	}

	@Override
	public final String getUserName() {
		return this.userName;
	}

	@Override
	public final void setUserName(final String userName) {
		this.userName = userName;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public void setPassword(final String password) {
		this.password = password;
	}

	@Override
	public final String getFirstName() {
		return this.firstName;
	}

	@Override
	public final void setFirstName(final String firstName) {
		this.firstName = firstName;
	}

	@Override
	public final String getLastName() {
		return this.lastName;
	}

	@Override
	public final void setLastName(final String lastName) {
		this.lastName = lastName;
	}

	@Override
	public final List<Recipe> getRecipes() {
		return this.recipes;
	}

	@Override
	public final void setRecipes(final Collection<Recipe> recipes) {
		this.recipes.clear();
		this.recipes.addAll(recipes);
	}

	@Override
	public final void addRecipe(final Recipe recipe) {
		this.recipes.add(recipe);
	}

	@Override
	public final void removeRecipe(final Recipe recipe) {
		this.recipes.remove(recipe);
	}

	@Override
	public final List<Family> getFamilies() {
		return this.families;
	}

	@Override
	public final void setFamilies(final Collection<Family> families) {
		this.families.clear();
		this.families.addAll(families);
	}

	@Override
	public final void addFamily(final Family family) {
		if (!this.families.contains(family)) {
			this.families.add(family);
		}
	}

	@Override
	public List<Comment> getComments() {
		return this.comments;
	}

	@Override
	public void setComments(final Collection<Comment> comments) {
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
		final MemberImpl other = (MemberImpl) obj;
		if (this.id != other.id) {
			return false;
		}
		return true;
	}

	@Override
	public boolean validateRequiredFields() {
		return !(this.userName.isEmpty() || this.lastName.isEmpty() || this.firstName.isEmpty() || this.password
				.isEmpty());
	}

}
