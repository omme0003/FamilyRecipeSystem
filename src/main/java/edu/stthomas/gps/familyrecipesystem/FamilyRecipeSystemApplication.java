package edu.stthomas.gps.familyrecipesystem;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.stthomas.gps.familyrecipesystem.dao.CommentDao;

public class FamilyRecipeSystemApplication {
	private final static ClassPathXmlApplicationContext CTX = new ClassPathXmlApplicationContext("beans.xml");

	public static void main(final String[] args) {
		new FamilyRecipeSystemApplication();

		final CommentDao commentDao = (CommentDao) FamilyRecipeSystemApplication.getContext().getBean("commentDao");
		commentDao.getCommentsByRecipe(1);

		// final JFrame frame = new JFrame("Test");
		// frame.show();
	}

	public FamilyRecipeSystemApplication() {
	}

	public static ClassPathXmlApplicationContext getContext() {
		return FamilyRecipeSystemApplication.CTX;
	}

}
