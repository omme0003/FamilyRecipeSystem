package edu.stthomas.gps.familyrecipesystem.dao;

import org.hibernate.Session;

import edu.stthomas.gps.familyrecipesystem.entity.Member;
import edu.stthomas.gps.familyrecipesystem.entity.MemberImpl;

public class MemberDaoImpl extends AbstractDaoImpl<Member> implements MemberDao {

	@Override
	public Member getMemberByUsernameAndPassword(final String userName, final String password) {
		final Session session = this.getSessionFactory().getCurrentSession();
		return (Member) session.createQuery("FROM member WHERE username = ? AND password = ?")
				.setParameter(0, userName).setParameter(1, password).uniqueResult();
	}

	@Override
	public Member getMemberByUserName(final String username) {
		final Session session = this.getSessionFactory().getCurrentSession();
		return (Member) session.createQuery("FROM member WHERE username = ?")
				.setParameter(0, username).uniqueResult();
	}

	@Override
	public Member getById(final Integer id) {
		return (Member) this.getSessionFactory().getCurrentSession().get(MemberImpl.class, id);
	}
}
