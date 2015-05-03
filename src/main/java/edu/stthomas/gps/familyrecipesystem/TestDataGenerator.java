package edu.stthomas.gps.familyrecipesystem;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.stthomas.gps.familyrecipesystem.dao.FamilyDao;
import edu.stthomas.gps.familyrecipesystem.dao.MemberDao;
import edu.stthomas.gps.familyrecipesystem.entity.Family;
import edu.stthomas.gps.familyrecipesystem.entity.FamilyImpl;
import edu.stthomas.gps.familyrecipesystem.entity.Member;
import edu.stthomas.gps.familyrecipesystem.entity.MemberImpl;

public class TestDataGenerator {

	private final ClassPathXmlApplicationContext ctx;

	public TestDataGenerator(final ClassPathXmlApplicationContext ctx) {
		this.ctx = ctx;
	}

	public void generate() {
		this.generateMembersAndFamilies();
	}

	private void generateMembersAndFamilies() {
		final FamilyDao familyDao = this.ctx.getBean("familyDao", FamilyDao.class);
		final Family johnson = new FamilyImpl();
		johnson.setName("Johnson's");
		familyDao.insert(johnson);

		final Family simpson = new FamilyImpl();
		simpson.setName("Simpson");
		familyDao.insert(simpson);

		final MemberDao memberDao = this.ctx.getBean("memberDao", MemberDao.class);
		final Member johnJohnson = new MemberImpl();
		johnJohnson.setUserName("j.johnson");
		johnJohnson.setLastName("Johnson");
		johnJohnson.setFirstName("John");
		johnJohnson.setPassword("abc123");
		final List<Family> families = new ArrayList<Family>();
		families.add(johnson);
		johnJohnson.setFamilies(families);
		memberDao.insert(johnJohnson);

		final Member maryJohnson = new MemberImpl();
		maryJohnson.setUserName("m.johnson");
		maryJohnson.setLastName("Mary");
		maryJohnson.setFirstName("John");
		maryJohnson.setPassword("abc123");
		families.clear();
		families.add(johnson);
		maryJohnson.setFamilies(families);
		memberDao.insert(maryJohnson);

		final Member homerSimpson = new MemberImpl();
		homerSimpson.setUserName("homer");
		homerSimpson.setLastName("Simpson");
		homerSimpson.setFirstName("Homer");
		homerSimpson.setPassword("duff");
		families.clear();
		families.add(simpson);
		homerSimpson.setFamilies(families);
		memberDao.insert(homerSimpson);

		final Member margeSimpson = new MemberImpl();
		margeSimpson.setUserName("marge");
		margeSimpson.setLastName("Simpson");
		margeSimpson.setFirstName("Marge");
		margeSimpson.setPassword("abc123");
		families.clear();
		families.add(simpson);
		margeSimpson.setFamilies(families);
		memberDao.insert(margeSimpson);

		final Member bartSimpson = new MemberImpl();
		bartSimpson.setUserName("bart");
		bartSimpson.setLastName("Simpson");
		bartSimpson.setFirstName("Bart");
		bartSimpson.setPassword("abc123");
		families.clear();
		families.add(simpson);
		bartSimpson.setFamilies(families);
		memberDao.insert(bartSimpson);

	}
}
