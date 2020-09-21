package ar.edu.unq.desapp.grupod.argconectadabackend.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

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
}
