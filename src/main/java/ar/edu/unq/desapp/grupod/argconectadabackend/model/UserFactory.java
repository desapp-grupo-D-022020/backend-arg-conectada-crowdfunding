package ar.edu.unq.desapp.grupod.argconectadabackend.model;

import java.time.LocalDateTime;

public class UserFactory {
	
	public static User anyUser() {
		return new User("anEmail","aPassword","aNickname",500,LocalDateTime.MIN);
	}
	
	public static User userZeroPoints() {
		return new User("anEmail","aPassword","aNickname",0,LocalDateTime.MIN);
	}
	
	public static User userLastDonationWithinThisMonth() {
		return new User("anEmail","aPassword","aNickname",0,LocalDateTime.now().minusDays(25));
	}

}
