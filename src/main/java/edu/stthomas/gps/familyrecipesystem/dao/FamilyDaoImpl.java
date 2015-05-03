package edu.stthomas.gps.familyrecipesystem.dao;

import java.util.List;

import org.hibernate.Session;

import edu.stthomas.gps.familyrecipesystem.entity.Family;

public class FamilyDaoImpl extends AbstractDaoImpl<Family> implements FamilyDao {

	@Override
	public List<Family> getAllFamilies() {
		final Session session = this.getSessionFactory().getCurrentSession();
		return session.createQuery("FROM family ORDER BY name").list();
	}

}
