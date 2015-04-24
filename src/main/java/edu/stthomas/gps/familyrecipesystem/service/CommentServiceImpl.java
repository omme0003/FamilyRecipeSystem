package edu.stthomas.gps.familyrecipesystem.service;

import org.springframework.transaction.annotation.Transactional;

import edu.stthomas.gps.familyrecipesystem.dao.CommentDao;
import edu.stthomas.gps.familyrecipesystem.entity.Comment;

public class CommentServiceImpl extends AbstractServiceImpl<CommentDao> implements CommentService {

	@Override
	@Transactional
	public void insert(final Comment comment) {
		this.getDao().insert(comment);
	}
}
