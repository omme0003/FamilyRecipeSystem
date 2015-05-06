package edu.stthomas.gps.familyrecipesystem;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.stthomas.gps.familyrecipesystem.dao.FamilyDao;
import edu.stthomas.gps.familyrecipesystem.dao.MemberDao;
import edu.stthomas.gps.familyrecipesystem.entity.Family;
import edu.stthomas.gps.familyrecipesystem.entity.FamilyImpl;
import edu.stthomas.gps.familyrecipesystem.entity.Member;
import edu.stthomas.gps.familyrecipesystem.entity.MemberImpl;
import edu.stthomas.gps.familyrecipesystem.entity.Recipe;
import edu.stthomas.gps.familyrecipesystem.entity.RecipeImpl;
import edu.stthomas.gps.familyrecipesystem.entity.Unit;
import edu.stthomas.gps.familyrecipesystem.service.MemberService;
import edu.stthomas.gps.familyrecipesystem.service.MemberServiceImpl;
import edu.stthomas.gps.familyrecipesystem.service.RecipeService;

public class TestDataGenerator {

	private final ClassPathXmlApplicationContext ctx;

	public TestDataGenerator(final ClassPathXmlApplicationContext ctx) {
		this.ctx = ctx;
	}

	public void generate() {
		// Families
		final FamilyDao familyDao = this.ctx.getBean("familyDao", FamilyDao.class);
		final Family johnson = new FamilyImpl();
		johnson.setName("Johnson");
		familyDao.insert(johnson);

		final Family simpson = new FamilyImpl();
		simpson.setName("Simpson");
		familyDao.insert(simpson);

		// Members
		final MemberDao memberDao = this.ctx.getBean("memberDao", MemberDao.class);
		final Member johnJohnson = new MemberImpl();
		johnJohnson.setUserName("j.johnson");
		johnJohnson.setLastName("Johnson");
		johnJohnson.setFirstName("John");
		johnJohnson.setPassword("abc123");
		johnJohnson.addFamily(johnson);
		memberDao.insert(johnJohnson);

		final Member maryJohnson = new MemberImpl();
		maryJohnson.setUserName("m.johnson");
		maryJohnson.setLastName("Mary");
		maryJohnson.setFirstName("John");
		maryJohnson.setPassword("abc123");
		maryJohnson.addFamily(johnson);
		memberDao.insert(maryJohnson);

		final Member homerSimpson = new MemberImpl();
		homerSimpson.setUserName("homer");
		homerSimpson.setLastName("Simpson");
		homerSimpson.setFirstName("Homer");
		homerSimpson.setPassword("duff");
		homerSimpson.addFamily(simpson);
		homerSimpson.addFamily(johnson);
		memberDao.insert(homerSimpson);

		final Member margeSimpson = new MemberImpl();
		margeSimpson.setUserName("marge");
		margeSimpson.setLastName("Simpson");
		margeSimpson.setFirstName("Marge");
		margeSimpson.setPassword("abc123");
		margeSimpson.addFamily(simpson);
		memberDao.insert(margeSimpson);

		final Member bartSimpson = new MemberImpl();
		bartSimpson.setUserName("bart");
		bartSimpson.setLastName("Simpson");
		bartSimpson.setFirstName("Bart");
		bartSimpson.setPassword("abc123");
		bartSimpson.addFamily(simpson);
		memberDao.insert(bartSimpson);

		// Recipes
		final MemberService memberService = FamilyRecipeSystemApplication.getContext().getBean("memberService",
				MemberServiceImpl.class);
		memberService.login("homer", "duff");

		final RecipeService recipeService = this.ctx.getBean("recipeService", RecipeService.class);

		final Recipe noodleBolognese = new RecipeImpl();
		noodleBolognese.addIngredient(2.5f, Unit.PC, "onion");
		noodleBolognese.addIngredient(5f, Unit.PC, "tomato");
		noodleBolognese.setName("Noodle bolognese");
		noodleBolognese.setDescription("Description");
		recipeService.insertOrUpdate(noodleBolognese);

		final Recipe homerSimpsonDogBurger = new RecipeImpl();
		homerSimpsonDogBurger.setName("Dog Burger");
		homerSimpsonDogBurger.setDescription("Marinate hot dogs in Duff Beer for 24 hours. "
				+ "Drain, then wrap hot dogs in burger meat to create a single large dog burger. "
				+ "Grill eight minutes each side, slap into roll, eat with Duff.");
		homerSimpsonDogBurger.addIngredient(4f, Unit.PC, "Hot dog");
		homerSimpsonDogBurger.addIngredient(1f, Unit.PC, "Duff beer");
		homerSimpsonDogBurger.addIngredient(1f, Unit.LBS, "hamburger meat");
		homerSimpsonDogBurger.addIngredient(1f, Unit.PC, "large roll");
		recipeService.insertOrUpdate(homerSimpsonDogBurger);

		memberService.logout();
		memberService.login("marge", "abc123");

		final Recipe bakedPotato = new RecipeImpl();
		bakedPotato.addIngredient(3.5f, Unit.PC, "onion");

		bakedPotato.setName("Baked potato");
		bakedPotato.setDescription("Description");
		recipeService.insertOrUpdate(bakedPotato);

		memberService.logout();
		memberService.login("j.johnson", "abc123");

		final Recipe carrotCake = new RecipeImpl();
		carrotCake.setName("Carrot Cake");
		carrotCake.setDescription("Preheat oven to 350F. "
				+ "Beat eggs until fluffy, then slowly fold in other ingredients "
				+ "until incorporated. Spread batter evenly in jelly roll pan "
				+ "and bake for 30-40 minutes or until lightly browned.");
		carrotCake.addIngredient(4f, Unit.PC, "eggs");
		carrotCake.addIngredient(1.5f, Unit.C, "flour");
		carrotCake.addIngredient(3f, Unit.PC, "carrot baby food");
		carrotCake.addIngredient(0.5f, Unit.C, "vegetable oil");
		carrotCake.addIngredient(1f, Unit.TBSP, "baking powder");
		carrotCake.addIngredient(1.5f, Unit.C, "sugar");
		recipeService.insertOrUpdate(carrotCake);

		final Recipe applePie = new RecipeImpl();
		applePie.setName("Granny's apple pie");
		applePie.setDescription(
				"1. Preheat oven to 425 degrees F (220 degrees C). Melt the butter in a saucepan. "
						+ "Stir in flour to form a paste. Add water, white sugar and brown sugar, and bring to a boil. "
						+ "Reduce temperature and let simmer.\n"
						+ "2. Place the bottom crust in your pan. Fill with apples, mounded slightly. "
						+ "Cover with a lattice work crust. Gently pour the sugar and butter liquid over the crust. "
						+ "Pour slowly so that it does not run off.\n"
						+ "3. Bake 15 minutes in the preheated oven. Reduce the temperature to 350 degrees F (175 degrees C). "
						+ "Continue baking for 35 to 45 minutes, until apples are soft.");
		applePie.addIngredient(.5f, Unit.C, "unsalted butter");
		applePie.addIngredient(3f, Unit.TBSP, "all-purpose flour");
		applePie.addIngredient(.25f, Unit.C, "water");
		applePie.addIngredient(0.5f, Unit.C, "white sugar");
		applePie.addIngredient(.5f, Unit.C, "brown sugar");
		applePie.addIngredient(8f, Unit.C, "Granny smith apples");
		recipeService.insertOrUpdate(applePie);

		memberService.logout();
	}
}
