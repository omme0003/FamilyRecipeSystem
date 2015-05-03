package edu.stthomas.gps.familyrecipesystem.dao;

import java.util.List;

import edu.stthomas.gps.familyrecipesystem.entity.Family;

public interface FamilyDao extends AbstractDao<Family> {

	public List<Family> getAllFamilies();

}
