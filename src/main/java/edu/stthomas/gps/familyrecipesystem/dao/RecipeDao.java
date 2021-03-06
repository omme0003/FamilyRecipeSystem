package edu.stthomas.gps.familyrecipesystem.dao;

import java.util.List;

import edu.stthomas.gps.familyrecipesystem.entity.Member;
import edu.stthomas.gps.familyrecipesystem.entity.Recipe;

public interface RecipeDao extends AbstractDao<Recipe> {

	public List<Recipe> searchByKeyword(String keyword);

	public List<Recipe> getByMember(Member member);
	
}
