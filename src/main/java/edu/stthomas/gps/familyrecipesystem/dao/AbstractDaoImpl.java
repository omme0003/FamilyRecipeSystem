package edu.stthomas.gps.familyrecipesystem.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class AbstractDaoImpl<Entity> implements AbstractDao<Entity> {
	private SessionFactory sessionFactory;

	@Override
	public void setSessionFactory(final SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public SessionFactory getSessionFactory() {
		return this.sessionFactory;
	}

	@Override
	public void update(final Entity entity) {
		final Session session = this.sessionFactory.getCurrentSession();
		session.update(entity);
	}

	@Override
	public void delete(final Entity entity) {
		final Session session = this.sessionFactory.getCurrentSession();
		session.delete(entity);
	}

	@Override
	public void insert(final Entity entity) {
		final Session session = this.sessionFactory.getCurrentSession();
		session.save(entity);
	}

}
