package ar.edu.unq.desapp.grupod.argconectadabackend.model;

public class DonorFactory {

	public static User anyDonor() {
		User anyDonor = new User("aName","aPassword","anEmail", "donor", "aNickname");
		anyDonor.setPoints(500.0);
		return anyDonor;
	}

	public static User donorZeroPoints() {
		return new User("aName","aPassword","anEmail", "donor", "aNickname");
	}

}