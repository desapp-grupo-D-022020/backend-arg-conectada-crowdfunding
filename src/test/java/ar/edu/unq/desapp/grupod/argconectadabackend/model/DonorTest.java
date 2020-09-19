package ar.edu.unq.desapp.grupod.argconectadabackend.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


public class DonorTest {
	
	@Test
    void addPointsToZeroAddsCorrectlyTheAmount() {
		Donor donorZeroPoints = DonorFactory.donorZeroPoints();
		donorZeroPoints.addPoints(500);
		int actualPoints = donorZeroPoints.getPoints();
    	assertEquals(500, actualPoints);
    }
	
	
	@Test
    void addPointsAddsCorrectlyTheAmount() {
		Donor anyDonor = DonorFactory.anyDonor();
		int points = anyDonor.getPoints();
    	anyDonor.addPoints(500);
    	assertEquals(points + 500, anyDonor.getPoints());
    }
	
	

}
