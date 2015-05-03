package edu.stthomas.gps.familyrecipesystem;

import java.awt.EventQueue;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.stthomas.gps.familyrecipesystem.gui.MainWindow;

public class FamilyRecipeSystemApplication {
	private final static ClassPathXmlApplicationContext CTX = new ClassPathXmlApplicationContext("beans.xml");

	public static void main(final String[] args) {
		final TestDataGenerator generator = new TestDataGenerator(FamilyRecipeSystemApplication.CTX);
		generator.generate();

		new FamilyRecipeSystemApplication();

		// final MemberService memberService =
		// FamilyRecipeSystemApplication.CTX.getBean("memberService",
		// MemberServiceImpl.class);
		// final boolean login = memberService.login("homer", "duff");
		// if (login) {
		// System.out.println("Login successful");
		// } else {
		// System.out.println("Login failed");
		// }
		//
		// final Member member =
		// memberService.getDao().getMemberByUserName("homer");
		// System.out.println(member.getFirstName());

		// final FamilyService familyService =
		// FamilyRecipeSystemApplication.CTX.getBean("familyService",
		// FamilyServiceImpl.class);
		// System.out.println(familyService.getAllFamilies());
		//
		// System.out.println(AppSession.getInstance().getUser().getFamilies());

		// final RecipeService service =
		// FamilyRecipeSystemApplication.CTX.getBean("recipeService",
		// RecipeServiceImpl.class);
		// final List<Recipe> recipe = service.searchByKeyword("noodle");
		// recipe.get(0).getIngredientOptions();

	}

	public FamilyRecipeSystemApplication() {
		EventQueue.invokeLater(() -> {
			try {
				final MainWindow window = new MainWindow(FamilyRecipeSystemApplication.CTX);
				window.setVisible(true);
			} catch (final Exception e) {
				e.printStackTrace();
			}
		});
	}

	public static ClassPathXmlApplicationContext getContext() {
		return FamilyRecipeSystemApplication.CTX;
	}

}
