package edu.stthomas.gps.familyrecipesystem.service;

import edu.stthomas.gps.familyrecipesystem.dao.AbstractDao;

public class AbstractServiceImpl<DaoType extends AbstractDao<?>> implements AbstractService<DaoType> {

	private DaoType dao;

	@Override
	public final DaoType getDao() {
		return this.dao;
	}

	@Override
	public final void setDao(final DaoType dao) {
		this.dao = dao;
	}

}
