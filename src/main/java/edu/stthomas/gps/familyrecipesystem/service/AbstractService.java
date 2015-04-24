package edu.stthomas.gps.familyrecipesystem.service;

public interface AbstractService<DaoType> {
	public DaoType getDao();

	public void setDao(final DaoType dao);
}
