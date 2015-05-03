package edu.stthomas.gps.familyrecipesystem.service;

import edu.stthomas.gps.familyrecipesystem.dao.CommentDao;
import edu.stthomas.gps.familyrecipesystem.entity.Comment;

public interface CommentService extends AbstractService<CommentDao> {
	public void insert(final Comment comment);
}
