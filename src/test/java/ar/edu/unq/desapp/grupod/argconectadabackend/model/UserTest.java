package ar.edu.unq.desapp.grupod.argconectadabackend.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import java.util.Map;

import org.junit.jupiter.api.Test;

public class UserTest {
	
	@Test
	void testGetName() {
		User user = DonorFactory.anyDonor();
		String actualName = user.getName();
		assertEquals("aName", actualName);
	}
	
	@Test
	void testSetName() {
		User user = DonorFactory.anyDonor();
		user.setName("anotherName");
		String actualName = user.getName();
		assertEquals("anotherName", actualName);
	}
	
	@Test
	void testGetPassword() {
		User user = DonorFactory.anyDonor();
		String actualPassword = user.getPassword();
		assertEquals("aPassword", actualPassword);
	}
	
	@Test
	void testSetPassword() {
		User user = DonorFactory.anyDonor();
		user.setPassword("anotherPassword");
		String actualPassword = user.getPassword();
		assertEquals("anotherPassword", actualPassword);
	}
	
	@Test
	void testGetEmail() {
		User user = DonorFactory.anyDonor();
		String actualEmail = user.getEmail();
		assertEquals("anEmail", actualEmail);
	}
	
	@Test
	void testSetEmail() {
		User user = DonorFactory.anyDonor();
		user.setEmail("anotherEmail");
		String actualEmail = user.getEmail();
		assertEquals("anotherEmail", actualEmail);
	}
	
	@Test
    void addPointsToZeroAddsCorrectlyTheAmount() {
		User donorZeroPoints = DonorFactory.donorZeroPoints();
		donorZeroPoints.addPoints(500.0);
		double actualPoints = donorZeroPoints.getPoints();
    	assertEquals(500, actualPoints);
    }
	
	
	@Test
    void addPointsAddsCorrectlyTheAmount() {
		User anyDonor = DonorFactory.anyDonor();
		double points = anyDonor.getPoints();
    	anyDonor.addPoints(500.0);
    	assertEquals(points + 500.0, anyDonor.getPoints());
    }
	
	@Test
	void addPointsCorrectlyAddsKeyToPointsRegistry() {
		User anyDonor = DonorFactory.anyDonor();
		anyDonor.addPointsToRegister("anyProject", (double) 2000);
		Map<String, Double> pointsRegistry = anyDonor.getPointsRegistry();
		assertTrue(pointsRegistry.containsKey("anyProject"));
	}
	
	@Test
	void addPointsCorrectlyAddsValueToPointsRegistry() {
		User anyDonor = DonorFactory.anyDonor();
		anyDonor.addPointsToRegister("anyProject", (double) 2500);
		Map<String, Double> pointsRegistry = anyDonor.getPointsRegistry();
		assertEquals(2500, pointsRegistry.get("anyProject"));
	}
	
//	@Test
//	void donateCallsCorrectly() {
//		User anyDonor = DonorFactory.anyDonor();
//		Project project = mock(Project.class);
//		anyDonor.donate(2000, "aCommentary", project);
//		verify(project, times(1)).receiveDonation(anyDonor, 2000, "aCommentary");
//	}
	
	// Getters and setters
	
	@Test
	void testGetPoints() {
		User anyDonor = DonorFactory.donorZeroPoints();
		assertEquals(anyDonor.getPoints(), 0);
	}
	
	@Test
	void testSetPoints() {
		User anyDonor = DonorFactory.anyDonor();
		anyDonor.setPoints((double) 1500);
		assertEquals(anyDonor.getPoints(), 1500);
	}
	
	@Test
	void testGetNickname() {
		User anyDonor = DonorFactory.anyDonor();
		assertEquals(anyDonor.getNickName(), "aNickname");
	}
	
	@Test
	void testSetNickname() {
		User anyDonor = DonorFactory.anyDonor();
		anyDonor.setNickName("newNickname");
		assertEquals(anyDonor.getNickName(), "newNickname");
	}
	
	@Test
	void testGetRewardProgram() {
		User anyDonor = DonorFactory.anyDonor();
		assertNotNull(anyDonor.getRewardProgram());
	}
	
	@Test
	void testSetRewardProgram() {
		RewardProgram rewardProgram = mock(RewardProgram.class);
		User anyDonor = DonorFactory.anyDonor();
		anyDonor.setRewardProgram(rewardProgram);
		assertNotNull(anyDonor.getRewardProgram());
	}
}
