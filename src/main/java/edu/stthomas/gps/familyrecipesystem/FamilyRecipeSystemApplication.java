package edu.stthomas.gps.familyrecipesystem;

import java.awt.EventQueue;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.stthomas.gps.familyrecipesystem.entity.Recipe;
import edu.stthomas.gps.familyrecipesystem.entity.Unit;
import edu.stthomas.gps.familyrecipesystem.gui.MainWindow;
import edu.stthomas.gps.familyrecipesystem.service.MemberService;
import edu.stthomas.gps.familyrecipesystem.service.MemberServiceImpl;
import edu.stthomas.gps.familyrecipesystem.service.RecipeService;
import edu.stthomas.gps.familyrecipesystem.service.RecipeServiceImpl;

public class FamilyRecipeSystemApplication {
	private final static ClassPathXmlApplicationContext CTX = new ClassPathXmlApplicationContext(
			"beans.xml");

	public static void main(final String[] args) {
		final TestDataGenerator generator = new TestDataGenerator(FamilyRecipeSystemApplication.CTX);
		generator.generate();

		// new FamilyRecipeSystemApplication();

		final MemberService memberService =
				FamilyRecipeSystemApplication.CTX.getBean("memberService",
						MemberServiceImpl.class);
		final boolean login = memberService.login("homer", "duff");
		if (login) {
			System.out.println("Login successful");
		} else {
			System.out.println("Login failed");
		}
		//
		// final Member member =
		// memberService.getDao().getMemberByUserName("homer");
		// System.out.println(member.getFirstName());
		// System.out.println(member.getFamilies());

		// final FamilyService familyService =
		// FamilyRecipeSystemApplication.CTX.getBean("familyService",
		// FamilyServiceImpl.class);
		// System.out.println(familyService.getAllFamilies());
		//
		// System.out.println(AppSession.getInstance().getUser().getFamilies());

		final RecipeService service =
				FamilyRecipeSystemApplication.CTX.getBean("recipeService",
						RecipeServiceImpl.class);
		final List<Recipe> recipes = service.searchByKeyword("noodle");
		System.out.println(recipes);
		final Recipe recipe = recipes.get(0);

		recipe.addIngredient(1f, Unit.TSP, "oregano");
		recipe.addIngredient(1f, Unit.PC, "hamburger meat");
		recipe.setName(recipe.getName() + "Test");
		service.insertOrUpdate(recipe);
		final List<Recipe> recipes2 = service.searchByKeyword("oregano");
		System.out.println(recipes2.get(0).getIngredientOptions());
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
