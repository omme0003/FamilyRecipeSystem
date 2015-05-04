package edu.stthomas.gps.familyrecipesystem.dao;

import edu.stthomas.gps.familyrecipesystem.entity.Member;

public interface MemberDao extends AbstractDao<Member> {

	public Member getMemberByUsernameAndPassword(final String username, final String password);

	public Member getMemberByUserName(final String username);

}
