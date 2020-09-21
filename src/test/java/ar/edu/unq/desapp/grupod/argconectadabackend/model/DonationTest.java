package ar.edu.unq.desapp.grupod.argconectadabackend.model;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

import org.junit.jupiter.api.Test;

public class DonationTest {
	
	@Test
	void recentDonationIsWithinCalendarMonth() {
		LocalDateTime dateTime = LocalDateTime.now();
		Donor anyDonor = DonorFactory.anyDonor();
		Donation donation = new Donation(anyDonor.getNickName(), 1000, dateTime,"aCommentary");
		assertTrue(donation.isWithinCalendarMonth());
	}
	
	@Test
	void firstDayOfMonthDonationIsWithinCalendarMonth() {
		LocalDateTime dateTime = LocalDateTime.now().with(TemporalAdjusters.firstDayOfMonth());
		Donor anyDonor = DonorFactory.anyDonor();
		Donation donation = new Donation(anyDonor.getNickName(), 1000, dateTime,"aCommentary");
		assertTrue(donation.isWithinCalendarMonth());
	}
	
	@Test
	void lastDayOfMonthDonationIsWithinCalendarMonth() {
		LocalDateTime dateTime = LocalDateTime.now().with(TemporalAdjusters.lastDayOfMonth());
		Donor anyDonor = DonorFactory.anyDonor();
		Donation donation = new Donation(anyDonor.getNickName(), 1000, dateTime,"aCommentary");
		assertTrue(donation.isWithinCalendarMonth());
	}
	
	@Test
	void donationIsBeforeCalendarMonth() {
		LocalDateTime dateTime = LocalDateTime.now().with(TemporalAdjusters.firstDayOfMonth()).minusDays(1);
		Donor anyDonor = DonorFactory.anyDonor();
		Donation donation = new Donation(anyDonor.getNickName(), 1000, dateTime,"aCommentary");
		assertFalse(donation.isWithinCalendarMonth());
	}
	
	@Test
	void donationIsAfterCalendarMonth() {
		LocalDateTime dateTime = LocalDateTime.now().with(TemporalAdjusters.lastDayOfMonth()).plusDays(1);
		Donor anyDonor = DonorFactory.anyDonor();
		Donation donation = new Donation(anyDonor.getNickName(), 1000, dateTime,"aCommentary");
		assertFalse(donation.isWithinCalendarMonth());
	}
	
	

}
