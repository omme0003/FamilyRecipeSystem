package edu.stthomas.gps.familyrecipesystem.dao;

import java.util.List;

import org.hibernate.Session;

import edu.stthomas.gps.familyrecipesystem.entity.Comment;

public class CommentDaoImpl extends AbstractDaoImpl<Comment> implements CommentDao {

	@Override
	public List<Comment> getCommentsByRecipe(final int recipeId) {
		final Session session = this.getSessionFactory().getCurrentSession();
		return session.createQuery("FROM comment WHERE recipe_id = ?").setParameter(0, recipeId).list();
	}

	@Override
	public List<Comment> getCommentsByMember(final int memberId) {
		final Session session = this.getSessionFactory().getCurrentSession();
		return session.createQuery("FROM comment WHERE member_id = ?").setParameter(0, memberId).list();
	}

	@Override
	public List<Comment> getCommentsByMemberAndRecipe(final int memberId, final int recipeId) {
		final Session session = this.getSessionFactory().getCurrentSession();
		return session.createQuery("FROM comment WHERE member_id = ? AND recipe_id = ?").setParameter(0, memberId).setParameter(1, recipeId).list();
	}

	@Override
	public Comment getCommentById(final int id) {
		final Session session = this.getSessionFactory().getCurrentSession();
		return (Comment) session.createQuery("FROM comment WHERE id = ?").setParameter(0, id).list().get(0);
	}

}
