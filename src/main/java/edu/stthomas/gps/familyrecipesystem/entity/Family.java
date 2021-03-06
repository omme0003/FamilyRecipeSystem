package edu.stthomas.gps.familyrecipesystem.entity;

import java.util.Collection;
import java.util.List;

public interface Family extends Entity {
	public Integer getId();

	public void setId(final Integer id);

	public String getName();

	public void setName(final String name);

	public List<Member> getMembers();

	public void setMembers(final Collection<Member> members);

	public void addMember(final Member member);

	public void removeMember(final Member member);
}
