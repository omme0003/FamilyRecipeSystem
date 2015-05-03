package edu.stthomas.gps.familyrecipesystem.service;

import edu.stthomas.gps.familyrecipesystem.AppSession;
import edu.stthomas.gps.familyrecipesystem.dao.MemberDao;
import edu.stthomas.gps.familyrecipesystem.entity.Member;

public class MemberServiceImpl extends AbstractServiceImpl<MemberDao> implements MemberService {

	@Override
	public boolean login(final String username, final String password) {
		final AppSession session = AppSession.getInstance();
		final Member member = this.getDao().getMemberByUsernameAndPassword(username, password);
		session.setUser(member);
		return member != null;
	}

	@Override
	public void create(final Member member) throws RequiredAttributesEmptyException, DuplicateUserException {
		if (!member.validateRequiredFields()) {
			throw new RequiredAttributesEmptyException();
		}
		if (this.getDao().getMemberByUserName(member.getUserName()) == null) {
			throw new DuplicateUserException();
		}

		this.getDao().insert(member);
	}

	@Override
	public void logout() {
		AppSession.getInstance().setUser(null);
	}

}
