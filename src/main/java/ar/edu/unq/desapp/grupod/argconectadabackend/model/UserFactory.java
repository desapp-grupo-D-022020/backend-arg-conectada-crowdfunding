package ar.edu.unq.desapp.grupod.argconectadabackend.model;

public class UserFactory {

	public static User anyDonor() {
		User anyDonor = new User("aName","aPassword","anEmail", "aNickname");
		anyDonor.setPoints(500.0);
		return anyDonor;
	}

	public static User donorZeroPoints() {
		return new User("aName","aPassword","anEmail", "aNickname");
	}
	
	public static User emptyDonor() {
		return new User("empty","empty","empty", "empty");
	}

}