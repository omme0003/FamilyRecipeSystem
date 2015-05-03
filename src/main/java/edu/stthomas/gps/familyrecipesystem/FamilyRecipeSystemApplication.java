package edu.stthomas.gps.familyrecipesystem;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.stthomas.gps.familyrecipesystem.service.MemberService;
import edu.stthomas.gps.familyrecipesystem.service.MemberServiceImpl;

public class FamilyRecipeSystemApplication {
	private final static ClassPathXmlApplicationContext CTX = new ClassPathXmlApplicationContext("beans.xml");

	public static void main(final String[] args) {
		new FamilyRecipeSystemApplication();

		final TestDataGenerator generator = new TestDataGenerator(FamilyRecipeSystemApplication.CTX);
		generator.generate();

		final MemberService memberService = FamilyRecipeSystemApplication.CTX.getBean("memberService", MemberServiceImpl.class);
		final boolean login = memberService.login("homer", "duff");
		if (login) {
			System.out.println("Login successfull");
		} else {
			System.out.println("Login failed");
		}

		// final JFrame frame = new JFrame("Test");
		// frame.show();
	}

	public FamilyRecipeSystemApplication() {
	}

	public static ClassPathXmlApplicationContext getContext() {
		return FamilyRecipeSystemApplication.CTX;
	}

}
