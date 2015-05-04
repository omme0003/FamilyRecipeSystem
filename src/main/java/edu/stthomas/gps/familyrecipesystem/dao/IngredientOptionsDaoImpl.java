package edu.stthomas.gps.familyrecipesystem.dao;

import edu.stthomas.gps.familyrecipesystem.entity.IngredientOptions;
import edu.stthomas.gps.familyrecipesystem.entity.IngredientOptionsImpl;


public class IngredientOptionsDaoImpl extends AbstractDaoImpl<IngredientOptions> implements IngredientOptionsDao {

	@Override
	public IngredientOptions getById(Integer id) {
		return (IngredientOptions) this.getSessionFactory().getCurrentSession().get(IngredientOptionsImpl.class, id);
	}


}
