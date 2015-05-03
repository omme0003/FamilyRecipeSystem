package edu.stthomas.gps.familyrecipesystem.service;

import edu.stthomas.gps.familyrecipesystem.dao.MemberDao;
import edu.stthomas.gps.familyrecipesystem.entity.DuplicateUserException;
import edu.stthomas.gps.familyrecipesystem.entity.Member;
import edu.stthomas.gps.familyrecipesystem.entity.RequiredAttributesEmptyException;

public interface MemberService extends AbstractService<MemberDao> {

	public boolean login(final String username, final String password);

	public void logout();

	public void create(final Member member) throws RequiredAttributesEmptyException, DuplicateUserException;

}
