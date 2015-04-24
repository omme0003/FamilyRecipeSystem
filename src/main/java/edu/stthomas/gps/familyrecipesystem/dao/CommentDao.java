package edu.stthomas.gps.familyrecipesystem.dao;

import java.util.List;

import edu.stthomas.gps.familyrecipesystem.entity.Comment;

public interface CommentDao extends AbstractDao<Comment> {
	public List<Comment> getCommentsByRecipe(final int recipeId);

	public List<Comment> getCommentsByMember(final int memberId);

	public List<Comment> getCommentsByMemberAndRecipe(final int memberId, final int recipeId);

	public Comment getCommentById(final int id);
}
