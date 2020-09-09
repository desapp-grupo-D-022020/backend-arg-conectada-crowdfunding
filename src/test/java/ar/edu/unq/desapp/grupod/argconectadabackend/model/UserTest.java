package ar.edu.unq.desapp.grupod.argconectadabackend.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


public class UserTest {
	
	@Test
    void addPointsToZeroAddsCorrectlyTheAmount() {
		User userZeroPoints = UserFactory.userZeroPoints();
		userZeroPoints.addPoints(500);
		int actualPoints = userZeroPoints.getPoints();
    	assertEquals(500, actualPoints);
    }
	
	
	@Test
    void addPointsAddsCorrectlyTheAmount() {
		User anyUser = UserFactory.anyUser();
		int points = anyUser.getPoints();
    	anyUser.addPoints(500);
    	assertEquals(points + 500, anyUser.getPoints());
    }
	
	
	@Test
	void dontReceivePoints() {
		User userZeroPoints = UserFactory.userZeroPoints();
		userZeroPoints.receivePoints(999);
		assertEquals(0, userZeroPoints.getPoints());
	}
	
	
	@Test
	void receivePointsEqualsAmountOfMoney() {
		User anyUser = UserFactory.anyUser();
		int points = anyUser.getPoints();
		anyUser.receivePoints(1000);
		assertEquals(points + 1000, anyUser.getPoints());
	}
	
	@Test
	void receiveBonusPoints(){
		User userHasDonatedMoneyOnThisMonth = UserFactory.userLastDonationWithinThisMonth();
		int points = userHasDonatedMoneyOnThisMonth.getPoints();
		userHasDonatedMoneyOnThisMonth.receivePoints(900);
		assertEquals(points + 1400, userHasDonatedMoneyOnThisMonth.getPoints());
	}
	
	/*
	@Test
	void sendMoneyToProjectAndDontReceivePoints() {
	
	}
	
	@Test
	void sendMoneyToProjectAndReceivePointsEqualToMoney() {
	
	}
	
	@Test
	void sendMoneyToProjectAndReceiveDoublePoints() {
	
	}
	
	@Test
	void sendMoneyToProjectAndReceiveBonusPoints() {
	
	}
	
	@Test
	void sendMoneyToProjectAndReceiveEqualToMoneyAndDoublePoints() {
	
	}
	
	@Test
	void sendMoneyToProjectAndReceiveEqualToMoneyAndBonusPoints() {
	
	}
	
	@Test
	void sendMoneyToProjectAndReceiveBonusAndDoublePoints() {
	
	}
	
	@Test
	void sendMoneyToProjectAndReceiveEqualToMoneyAndBonusAndDoublePoints() {
	
	}
	
	*/
	
	

}
