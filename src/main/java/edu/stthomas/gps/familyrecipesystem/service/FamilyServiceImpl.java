package edu.stthomas.gps.familyrecipesystem.service;

import java.util.List;

import edu.stthomas.gps.familyrecipesystem.dao.FamilyDao;
import edu.stthomas.gps.familyrecipesystem.entity.Family;

public class FamilyServiceImpl extends AbstractServiceImpl<FamilyDao> implements FamilyService {

	@Override
	public List<Family> getAllFamilies() {
		return this.getDao().getAllFamilies();
	}
	
	@Override
	public Family getById(final Integer id) {
		return this.getDao().getById(id);
	}
}
