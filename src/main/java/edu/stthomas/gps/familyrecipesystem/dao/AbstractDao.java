package edu.stthomas.gps.familyrecipesystem.dao;

import org.hibernate.SessionFactory;

public interface AbstractDao<Entity extends edu.stthomas.gps.familyrecipesystem.entity.Entity> {
	public void setSessionFactory(final SessionFactory sessionFactory);

	public SessionFactory getSessionFactory();

	public void insert(final Entity entity);

	public void update(final Entity entity);

	public void delete(final Entity entity);

}
