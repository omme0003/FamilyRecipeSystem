package edu.stthomas.gps.familyrecipesystem.dao;

import java.util.List;

import org.hibernate.Session;

import edu.stthomas.gps.familyrecipesystem.entity.Recipe;

public class RecipeDaoImpl extends AbstractDaoImpl<Recipe> implements RecipeDao {

	@Override
	public List<Recipe> searchByKeyword(final String keyword) {
		final Session session = this.getSessionFactory().getCurrentSession();
		final String search = "%" + keyword.toLowerCase().trim() + "%";

		final List<Integer> relatedMembers = this.getMemberIdsOfRelatedFamilies();

		return session
				.createQuery(
						"SELECT DISTINCT r FROM recipe AS r JOIN r.managedBy AS m JOIN r.ingredientOptions AS ingOpt JOIN ingOpt.ingredient as ing "
								+ "WHERE (lower(r.name) LIKE :keyword OR lower(r.description) LIKE :keyword OR lower(ing.name) LIKE :keyword) "
								+ "AND m.id IN (:relatedMembers) ORDER BY name")
				.setParameter("keyword", search).setParameterList("relatedMembers", relatedMembers)
				.list();

	}
}
