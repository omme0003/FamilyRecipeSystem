package edu.stthomas.gps.familyrecipesystem;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.stthomas.gps.familyrecipesystem.dao.CommentDao;
import edu.stthomas.gps.familyrecipesystem.dao.MemberDao;
import edu.stthomas.gps.familyrecipesystem.entity.Member;
import edu.stthomas.gps.familyrecipesystem.entity.MemberImpl;

public class FamilyRecipeSystemApplication {
	private final static ClassPathXmlApplicationContext CTX = new ClassPathXmlApplicationContext("beans.xml");

	public static void main(final String[] args) {
		new FamilyRecipeSystemApplication();

		final CommentDao commentDao = (CommentDao) FamilyRecipeSystemApplication.getContext().getBean("commentDao");
		commentDao.getCommentsByRecipe(1);

		final MemberDao memberDao = (MemberDao) FamilyRecipeSystemApplication.getContext().getBean("memberDao");
		final Member member = new MemberImpl();
		member.setLastName("Johnson");
		member.setFirstName("John");
		member.setPassword("abc123");
		memberDao.insert(member);

		// final JFrame frame = new JFrame("Test");
		// frame.show();
	}

	public FamilyRecipeSystemApplication() {
	}

	public static ClassPathXmlApplicationContext getContext() {
		return FamilyRecipeSystemApplication.CTX;
	}

}
