package edu.stthomas.gps.familyrecipesystem;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.stthomas.gps.familyrecipesystem.dao.FamilyDao;
import edu.stthomas.gps.familyrecipesystem.dao.MemberDao;
import edu.stthomas.gps.familyrecipesystem.entity.Family;
import edu.stthomas.gps.familyrecipesystem.entity.FamilyImpl;
import edu.stthomas.gps.familyrecipesystem.entity.Ingredient;
import edu.stthomas.gps.familyrecipesystem.entity.IngredientImpl;
import edu.stthomas.gps.familyrecipesystem.entity.IngredientOptions;
import edu.stthomas.gps.familyrecipesystem.entity.IngredientOptionsImpl;
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
		johnson.setName("Johnson's");
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
		final boolean login = memberService.login("homer", "duff");

		final RecipeService recipeService = this.ctx.getBean("recipeService", RecipeService.class);

		final Recipe noodleBolognese = new RecipeImpl();
		final List<IngredientOptions> ingredientOptions = new ArrayList<IngredientOptions>();

		final Ingredient onion = new IngredientImpl();
		onion.setName("onion");
		final IngredientOptions option = new IngredientOptionsImpl();
		option.setIngredient(onion);
		option.setQuantity(2.5f);
		option.setRecipe(noodleBolognese);
		option.setUnit(Unit.PC);
		ingredientOptions.add(option);

		final Ingredient tomato = new IngredientImpl();
		tomato.setName("tomato");
		final IngredientOptions tomatoOption = new IngredientOptionsImpl(2.5f, Unit.PC, tomato, noodleBolognese);
		ingredientOptions.add(tomatoOption);

		noodleBolognese.setIngredientOptions(ingredientOptions);
		noodleBolognese.setName("Noodle bolognese");
		noodleBolognese.setDescription("Description");
		noodleBolognese.setManagedBy(homerSimpson);
		recipeService.insertOrUpdate(noodleBolognese);

		final Recipe bakedPotato = new RecipeImpl();
		final List<IngredientOptions> ingredientOptions2 = new ArrayList<IngredientOptions>();

		final Ingredient onion2 = new IngredientImpl();
		onion2.setName("onion");
		final IngredientOptions option2 = new IngredientOptionsImpl(3.5f, Unit.PC, onion2, bakedPotato);
		bakedPotato.addIngredientOptions(option2);

		bakedPotato.setName("Baked potato");
		bakedPotato.setDescription("Description");
		bakedPotato.setManagedBy(homerSimpson);
		recipeService.insertOrUpdate(bakedPotato);

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
	}
}
