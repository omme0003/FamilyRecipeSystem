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
						"SELECT r FROM recipe AS r JOIN r.managedBy AS m WHERE (lower(r.name) LIKE :name OR lower(r.description) LIKE :desc) "
								+ "AND m.id IN (:relatedMembers) ORDER BY name")
								.setParameter("name", search).setParameter("desc", search)
								.setParameterList("relatedMembers", relatedMembers).list();

	}
}
