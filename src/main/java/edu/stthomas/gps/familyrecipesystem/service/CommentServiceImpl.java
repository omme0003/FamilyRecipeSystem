package edu.stthomas.gps.familyrecipesystem.service;

import java.util.Date;

import edu.stthomas.gps.familyrecipesystem.dao.CommentDao;
import edu.stthomas.gps.familyrecipesystem.entity.Comment;

public class CommentServiceImpl extends AbstractServiceImpl<CommentDao> implements CommentService {

	@Override
	public void insert(final Comment comment) {
		comment.setCreated(new Date());
		this.getDao().insert(comment);
	}
}
