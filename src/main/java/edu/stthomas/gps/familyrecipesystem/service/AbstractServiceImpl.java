package edu.stthomas.gps.familyrecipesystem.service;

public class AbstractServiceImpl<DaoType> implements AbstractService<DaoType> {

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
