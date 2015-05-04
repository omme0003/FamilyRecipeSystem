package edu.stthomas.gps.familyrecipesystem.dao;

import org.hibernate.Session;

import edu.stthomas.gps.familyrecipesystem.entity.Member;

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
	public Member getMemberById(final int id) {
		final Session session = this.getSessionFactory().getCurrentSession();
		return (Member) session.createQuery("FROM member WHERE id = ?").setParameter(0, id)
				.uniqueResult();
	}
}
