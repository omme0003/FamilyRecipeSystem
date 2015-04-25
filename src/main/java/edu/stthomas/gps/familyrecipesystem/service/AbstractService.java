package edu.stthomas.gps.familyrecipesystem.service;

import edu.stthomas.gps.familyrecipesystem.dao.AbstractDao;

public interface AbstractService<DaoType extends AbstractDao<?>> {
	public DaoType getDao();

	public void setDao(final DaoType dao);
}
