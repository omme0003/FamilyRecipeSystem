package edu.stthomas.gps.familyrecipesystem.dao;

import java.util.List;

import org.hibernate.Session;

import edu.stthomas.gps.familyrecipesystem.entity.Member;

public class MemberDaoImpl extends AbstractDaoImpl<Member> implements MemberDao {

	@Override
	public Member getMemberByUsernameAndPassword(final String userName, final String password) {
		final Session session = this.getSessionFactory().getCurrentSession();
		final List<Member> members = session.createQuery("FROM member WHERE username = ? AND password = ?").setParameter(0, userName).setParameter(1, password)
				.list();
		if (members.isEmpty()) {
			return null;
		} else {
			return members.get(0);
		}
	}

	@Override
	public Member getMemberByUserName(final String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
