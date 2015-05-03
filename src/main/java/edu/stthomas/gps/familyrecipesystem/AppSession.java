package edu.stthomas.gps.familyrecipesystem;

import edu.stthomas.gps.familyrecipesystem.entity.Member;

public class AppSession {

	private Member user;
	private static final AppSession INSTANCE = new AppSession();

	public AppSession() {

	}

	public Member getUser() {
		return this.user;
	}

	public void setUser(final Member user) {
		this.user = user;
	}

	public static AppSession getInstance() {
		return AppSession.INSTANCE;
	}

}
