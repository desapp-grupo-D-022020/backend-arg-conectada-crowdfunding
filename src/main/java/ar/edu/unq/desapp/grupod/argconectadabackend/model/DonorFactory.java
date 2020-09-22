package ar.edu.unq.desapp.grupod.argconectadabackend.model;

public class DonorFactory {

	public static Donor anyDonor() {
		Donor anyDonor = new Donor("aName","aPassword","anEmail","aNickname");
		anyDonor.setPoints(500.0);
		return anyDonor;
	}

	public static Donor donorZeroPoints() {
		return new Donor("aName","aPassword","anEmail","aNickname");
	}

}