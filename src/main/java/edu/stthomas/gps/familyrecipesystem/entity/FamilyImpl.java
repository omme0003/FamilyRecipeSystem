package edu.stthomas.gps.familyrecipesystem.entity;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity(name = "family")
public class FamilyImpl implements Family {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	private Integer id;

	@Column(name = "family_name", unique = true, nullable = false)
	private String name;

	@ManyToMany(targetEntity = MemberImpl.class, cascade = CascadeType.ALL, mappedBy = "families")
	private List<Member> members;

	@Override
	public final Integer getId() {
		return this.id;
	}

	@Override
	public final void setId(final Integer id) {
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
	public final List<Member> getMembers() {
		return Collections.unmodifiableList(this.members);
	}

	@Override
	public final void setMembers(final Collection<Member> members) {
		this.members.clear();
		this.members.addAll(members);
	}

	@Override
	public void addMember(final Member member) {
		this.members.add(member);
	}

	@Override
	public void removeMember(final Member member) {
		this.members.remove(member);
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
		final FamilyImpl other = (FamilyImpl) obj;
		if (this.id != other.id) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return this.name;
	}

}
