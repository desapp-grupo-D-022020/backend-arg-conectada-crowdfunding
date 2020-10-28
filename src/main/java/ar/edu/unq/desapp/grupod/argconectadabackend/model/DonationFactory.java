package ar.edu.unq.desapp.grupod.argconectadabackend.model;

import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

public class DonationFactory {
	
	public static Donation anyDonation() {
		LocalDateTime dateTime = LocalDateTime.now();
		User anyDonor = UserFactory.anyDonor();
		Donation anyDonation = new Donation(anyDonor, 1000, dateTime,"aCommentary");
		
		return anyDonation;
	}
	
	public static Donation firstDayOfMonthDonation() {
		LocalDateTime dateTime = LocalDateTime.now().with(TemporalAdjusters.firstDayOfMonth());
		User anyDonor = UserFactory.anyDonor();
		Donation firstDayOfMonthDonation = new Donation(anyDonor, 1000, dateTime,"aCommentary");
		
		return firstDayOfMonthDonation;
	}
	
	public static Donation lastDayOfMonthDonation() {
		LocalDateTime dateTime = LocalDateTime.now().with(TemporalAdjusters.lastDayOfMonth());
		User anyDonor = UserFactory.anyDonor();
		Donation lastDayOfMonthDonation = new Donation(anyDonor, 1000, dateTime,"aCommentary");
		
		return lastDayOfMonthDonation;
	}
	
	public static Donation beforeMonthDonation() {
		LocalDateTime dateTime = LocalDateTime.now().with(TemporalAdjusters.firstDayOfMonth()).minusDays(1);
		User anyDonor = UserFactory.anyDonor();
		Donation beforeMonthDonation = new Donation(anyDonor, 1000, dateTime,"aCommentary");
		
		return beforeMonthDonation;
	}
	
	public static Donation afterMonthDonation() {
		LocalDateTime dateTime = LocalDateTime.now().with(TemporalAdjusters.lastDayOfMonth()).plusDays(1);
		User anyDonor = UserFactory.anyDonor();
		Donation afterMonthDonation = new Donation(anyDonor, 1000, dateTime,"aCommentary");
		
		return afterMonthDonation;
	}
	
	public static Donation emptyDonation() {
		User emptyDonor = UserFactory.emptyDonor();
		Donation emptyDonation = new Donation(emptyDonor, 0, LocalDateTime.MIN,"no donations yet");
		
		return emptyDonation;
	}
}
