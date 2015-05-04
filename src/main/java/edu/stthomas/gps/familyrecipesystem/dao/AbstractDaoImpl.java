package edu.stthomas.gps.familyrecipesystem.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.stthomas.gps.familyrecipesystem.AppSession;
import edu.stthomas.gps.familyrecipesystem.entity.Family;

@Transactional
@Repository
public class AbstractDaoImpl<Entity extends edu.stthomas.gps.familyrecipesystem.entity.Entity>
implements AbstractDao<Entity> {
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
		session.merge(entity);
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

	@Override
	public void saveOrUpdate(final Entity entity) {
		final Session session = this.sessionFactory.getCurrentSession();
		session.save(entity);
	}

	protected List<Integer> getMemberIdsOfRelatedFamilies() {
		final Session session = this.sessionFactory.getCurrentSession();
		final AppSession appSession = AppSession.getInstance();
		final List<Integer> familyIds = new ArrayList<Integer>();
		for (final Family family : appSession.getUser().getFamilies()) {
			familyIds.add(family.getId());
		}

		return session
				.createQuery(
						"SELECT DISTINCT m1.id FROM member AS m1 JOIN m1.families AS f1 WHERE f1.id IN (:families)")
						.setParameterList("families", familyIds).list();
	}
}
