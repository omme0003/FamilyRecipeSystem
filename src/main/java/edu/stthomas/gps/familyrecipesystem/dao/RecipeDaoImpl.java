package edu.stthomas.gps.familyrecipesystem.dao;

import java.util.List;

import org.hibernate.Session;

import edu.stthomas.gps.familyrecipesystem.entity.Recipe;

public class RecipeDaoImpl extends AbstractDaoImpl<Recipe> implements RecipeDao {

	@Override
	public List<Recipe> searchByKeyword(final String keyword) {
		final Session session = this.getSessionFactory().getCurrentSession();
		final String search = "%" + keyword.toLowerCase().trim() + "%";
		return session.createQuery("FROM recipe WHERE lower(name) LIKE :name OR lower(description) LIKE :desc ORDER BY name").setParameter("name", search)
				.setParameter("desc", search).list();

		// final AppSession appSession = AppSession.getInstance();
		// final Session session = this.getSessionFactory().getCurrentSession();
		// final String search = "%" + keyword.toLowerCase().trim() + "%";
		// final List<Integer> familyIds = new ArrayList<Integer>();
		// for (final Family family : appSession.getUser().getFamilies()) {
		// familyIds.add(family.getId());
		// }
		// return session
		// .createQuery(
		// "FROM recipe AS r inner join member_family AS mf WHERE (lower(r.name) LIKE :name OR lower(r.description) LIKE :desc) AND mf.family_id IN (:families) ORDER BY name")
		// .setParameter("name", search).setParameter("desc",
		// search).setParameterList("families", familyIds).list();
	}
}
