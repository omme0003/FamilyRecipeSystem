package edu.stthomas.gps.familyrecipesystem.service;

import java.util.List;

import edu.stthomas.gps.familyrecipesystem.dao.FamilyDao;
import edu.stthomas.gps.familyrecipesystem.entity.Family;

public interface FamilyService extends AbstractService<FamilyDao> {

	public List<Family> getAllFamilies();

}
