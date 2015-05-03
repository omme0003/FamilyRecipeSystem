package edu.stthomas.gps.familyrecipesystem.service;

import edu.stthomas.gps.familyrecipesystem.dao.MemberDao;
import edu.stthomas.gps.familyrecipesystem.entity.Member;

public interface MemberService extends AbstractService<MemberDao> {

	public boolean login(final String username, final String password);

	public void logout();

	public boolean create(final Member member);

}
