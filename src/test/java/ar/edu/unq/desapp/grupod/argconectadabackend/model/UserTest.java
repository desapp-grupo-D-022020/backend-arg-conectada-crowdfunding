package ar.edu.unq.desapp.grupod.argconectadabackend.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;

public class UserTest {
	
	@Test
	void testGetName() {
		User user = UserFactory.anyDonor();
		String actualName = user.getName();
		assertEquals("aName", actualName);
	}
	
	@Test
	void testSetName() {
		User user = UserFactory.anyDonor();
		user.setName("anotherName");
		String actualName = user.getName();
		assertEquals("anotherName", actualName);
	}
	
	@Test
	void testGetPassword() {
		User user = UserFactory.anyDonor();
		String actualPassword = user.getPassword();
		assertEquals("aPassword", actualPassword);
	}
	
	@Test
	void testSetPassword() {
		User user = UserFactory.anyDonor();
		user.setPassword("anotherPassword");
		String actualPassword = user.getPassword();
		assertEquals("anotherPassword", actualPassword);
	}
	
	@Test
	void testGetEmail() {
		User user = UserFactory.anyDonor();
		String actualEmail = user.getEmail();
		assertEquals("anEmail", actualEmail);
	}
	
	@Test
	void testSetEmail() {
		User user = UserFactory.anyDonor();
		user.setEmail("anotherEmail");
		String actualEmail = user.getEmail();
		assertEquals("anotherEmail", actualEmail);
	}
	
	@Test
    void addPointsToZeroAddsCorrectlyTheAmount() {
		User donorZeroPoints = UserFactory.donorZeroPoints();
		donorZeroPoints.addPoints(500.0);
		double actualPoints = donorZeroPoints.getPoints();
    	assertEquals(500, actualPoints);
    }
	
	
	@Test
    void addPointsAddsCorrectlyTheAmount() {
		User anyDonor = UserFactory.anyDonor();
		double points = anyDonor.getPoints();
    	anyDonor.addPoints(500.0);
    	assertEquals(points + 500.0, anyDonor.getPoints());
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
		User anyDonor = UserFactory.donorZeroPoints();
		assertEquals(anyDonor.getPoints(), 0);
	}
	
	@Test
	void testSetPoints() {
		User anyDonor = UserFactory.anyDonor();
		anyDonor.setPoints((double) 1500);
		assertEquals(anyDonor.getPoints(), 1500);
	}
	
	@Test
	void testGetNickname() {
		User anyDonor = UserFactory.anyDonor();
		assertEquals(anyDonor.getUserName(), "aNickname");
	}
	
	@Test
	void testSetNickname() {
		User anyDonor = UserFactory.anyDonor();
		anyDonor.setUserName("newNickname");
		assertEquals(anyDonor.getUserName(), "newNickname");
	}
	
	@Test
	void testGetRewardProgram() {
		User anyDonor = UserFactory.anyDonor();
		assertNotNull(anyDonor.getRewardProgram());
	}
	
	@Test
	void testSetRewardProgram() {
		RewardProgram rewardProgram = mock(RewardProgram.class);
		User anyDonor = UserFactory.anyDonor();
		anyDonor.setRewardProgram(rewardProgram);
		assertNotNull(anyDonor.getRewardProgram());
	}
}
