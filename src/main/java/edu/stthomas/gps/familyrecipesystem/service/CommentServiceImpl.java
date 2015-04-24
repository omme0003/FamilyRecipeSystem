package edu.stthomas.gps.familyrecipesystem.service;

import edu.stthomas.gps.familyrecipesystem.dao.CommentDao;
import edu.stthomas.gps.familyrecipesystem.entity.Comment;

public class CommentServiceImpl extends AbstractServiceImpl<CommentDao> implements CommentService {

	@Override
	public void insert(final Comment comment) {
		this.getDao().insert(comment);
	}
}
