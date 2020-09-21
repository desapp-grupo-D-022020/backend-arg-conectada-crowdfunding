package ar.edu.unq.desapp.grupod.argconectadabackend.model;

import static org.hamcrest.CoreMatchers.any;
import static org.hamcrest.CoreMatchers.anything;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.Map;

import org.junit.jupiter.api.Test;

import ar.edu.unq.desapp.grupod.argconectadabackend.service.EmailSender;


public class DonorTest {
	
	@Test
    void addPointsToZeroAddsCorrectlyTheAmount() {
		Donor donorZeroPoints = DonorFactory.donorZeroPoints();
		donorZeroPoints.addPoints(500.0);
		double actualPoints = donorZeroPoints.getPoints();
    	assertEquals(500, actualPoints);
    }
	
	
	@Test
    void addPointsAddsCorrectlyTheAmount() {
		Donor anyDonor = DonorFactory.anyDonor();
		double points = anyDonor.getPoints();
    	anyDonor.addPoints(500.0);
    	assertEquals(points + 500.0, anyDonor.getPoints());
    }
	
	@Test
	void addPointsCorrectlyAddsKeyToPointsRegistry() {
		Donor anyDonor = DonorFactory.anyDonor();
		anyDonor.addPointsToRegister("anyProject", (double) 2000);
		Map<String, Double> pointsRegistry = anyDonor.getPointsRegistry();
		assertTrue(pointsRegistry.containsKey("anyProject"));
	}
	
	@Test
	void addPointsCorrectlyAddsValueToPointsRegistry() {
		Donor anyDonor = DonorFactory.anyDonor();
		anyDonor.addPointsToRegister("anyProject", (double) 2500);
		Map<String, Double> pointsRegistry = anyDonor.getPointsRegistry();
		assertEquals(2500, pointsRegistry.get("anyProject"));
	}
	
	@Test
	void donateCallsCorrectly() {
		Donor anyDonor = DonorFactory.anyDonor();
		Project project = mock(Project.class);
		anyDonor.donate(2000, "aCommentary", project);
		verify(project, times(1)).receiveDonation(anyDonor, 2000, "aCommentary");
	}
	
	/*@Test
	void updateCallsCorrectly() {
		Donor anyDonor = DonorFactory.anyDonor();
		EmailSender mailSender = anyDonor.getEmailSender();
		anyDonor.update();
		verify(mailSender, times(1)).closeProyectEmail(anyDonor.getEmail(),anyDonor.getNickName());
	}*/
	
	// Getters and setters
	
	@Test
	void testGetPoints() {
		Donor anyDonor = DonorFactory.donorZeroPoints();
		assertEquals(anyDonor.getPoints(), 0);
	}
	
	@Test
	void testSetPoints() {
		Donor anyDonor = DonorFactory.anyDonor();
		anyDonor.setPoints((double) 1500);
		assertEquals(anyDonor.getPoints(), 1500);
	}
	
	@Test
	void testGetNickname() {
		Donor anyDonor = DonorFactory.anyDonor();
		assertEquals(anyDonor.getNickName(), "aNickname");
	}
	
	@Test
	void testSetNickname() {
		Donor anyDonor = DonorFactory.anyDonor();
		anyDonor.setNickName("newNickname");
		assertEquals(anyDonor.getNickName(), "newNickname");
	}
	
	@Test
	void testGetRewardProgram() {
		Donor anyDonor = DonorFactory.anyDonor();
		assertNotNull(anyDonor.getRewardProgram());
	}
	
	@Test
	void testSetRewardProgram() {
		RewardProgram rewardProgram = mock(RewardProgram.class);
		Donor anyDonor = DonorFactory.anyDonor();
		anyDonor.setRewardProgram(rewardProgram);
		assertNotNull(anyDonor.getRewardProgram());
	}
	
	

}
