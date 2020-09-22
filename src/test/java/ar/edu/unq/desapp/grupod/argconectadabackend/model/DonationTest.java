package ar.edu.unq.desapp.grupod.argconectadabackend.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

import org.junit.jupiter.api.Test;

public class DonationTest {
	
	@Test
	void recentDonationIsWithinCalendarMonth() {
		Donation anyDonation = DonationFactory.anyDonation();
		assertTrue(anyDonation.isWithinCalendarMonth());
	}
	
	@Test
	void firstDayOfMonthDonationIsWithinCalendarMonth() {
		Donation firstDayOfMonthDonation = DonationFactory.firstDayOfMonthDonation(); 
		assertTrue(firstDayOfMonthDonation.isWithinCalendarMonth());
	}
	
	@Test
	void lastDayOfMonthDonationIsWithinCalendarMonth() {
		Donation lastDayOfMonthDonation = DonationFactory.lastDayOfMonthDonation();
		assertTrue(lastDayOfMonthDonation.isWithinCalendarMonth());
	}
	
	@Test
	void donationIsBeforeCalendarMonth() {
		Donation beforeMonthDonation = DonationFactory.beforeMonthDonation();
		assertFalse(beforeMonthDonation.isWithinCalendarMonth());
	}
	
	@Test
	void donationIsAfterCalendarMonth() {
		Donation afterMonthDonation = DonationFactory.afterMonthDonation();
		assertFalse(afterMonthDonation.isWithinCalendarMonth());
	}
	
	// Getter and setters
	
	@Test
	void testGetNicknameUser() {
		Donation anyDonation = DonationFactory.anyDonation();
		String actualNickname = anyDonation.getNickNameUser();
		assertEquals("aNickname", actualNickname);
	}
	
	@Test
	void testGetAmount() {
		Donation anyDonation = DonationFactory.anyDonation();
		Double actualAmount = anyDonation.getAmount();
		assertEquals(1000, actualAmount);
	}
	
	@Test
	void testSetAmount() {
		Donation anyDonation = DonationFactory.anyDonation();
		anyDonation.setAmount(2500);
		Double actualAmount = anyDonation.getAmount();
		assertEquals(2500, actualAmount);
	}
	
	@Test
	void testGetDate() {
		Donation anyDonation = DonationFactory.firstDayOfMonthDonation();
		LocalDateTime actualDate = anyDonation.getDate();
		assertNotNull(actualDate);
	}
	
	@Test
	void testSetDate() {
		Donation anyDonation = DonationFactory.anyDonation();
		LocalDateTime newDateTime = LocalDateTime.now().with(TemporalAdjusters.firstDayOfYear());
		anyDonation.setDate(newDateTime);
		LocalDateTime actualDate = anyDonation.getDate();
		assertEquals(newDateTime, actualDate);
	}
	
	@Test
	void testGetCommentary() {
		Donation anyDonation = DonationFactory.anyDonation();
		String actualCommentary = anyDonation.getCommentary();
		assertEquals("aCommentary", actualCommentary);
	}
	
	@Test
	void testSetCommentary() {
		Donation anyDonation = DonationFactory.anyDonation();
		anyDonation.setCommentary("anotherCommentary");
		String actualCommentary = anyDonation.getCommentary();
		assertEquals("anotherCommentary", actualCommentary);
	}	
}
