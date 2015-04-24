package edu.stthomas.gps.familyrecipesystem.entity;

import javax.persistence.Entity;

@Entity
public enum Unit {
	G("g", "gram"), KG("kg", "kilogram"), LBS("lbs", "pound"), TSP("tsp", "teaspoon"), TBSP("tbsp", "tablespoon"), FLOZ("floz", "fluid ounce"), GAL("gal",
			"gallone"), PC("pc", "pieces");

	private final String nameShort;
	private final String nameLong;

	Unit(final String nameShort, final String nameLong) {
		this.nameShort = nameShort;
		this.nameLong = nameLong;
	}

	public final String getNameShort() {
		return this.nameShort;
	}

	public final String getNameLong() {
		return this.nameLong;
	}

}
