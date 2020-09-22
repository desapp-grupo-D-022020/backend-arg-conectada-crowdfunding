package ar.edu.unq.desapp.grupod.argconectadabackend.model;

import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

public class DonationFactory {
	
	public static Donation anyDonation() {
		LocalDateTime dateTime = LocalDateTime.now();
		Donor anyDonor = DonorFactory.anyDonor();
		Donation anyDonation = new Donation(anyDonor, 1000, dateTime,"aCommentary");
		
		return anyDonation;
	}
	
	public static Donation firstDayOfMonthDonation() {
		LocalDateTime dateTime = LocalDateTime.now().with(TemporalAdjusters.firstDayOfMonth());
		Donor anyDonor = DonorFactory.anyDonor();
		Donation firstDayOfMonthDonation = new Donation(anyDonor, 1000, dateTime,"aCommentary");
		
		return firstDayOfMonthDonation;
	}
	
	public static Donation lastDayOfMonthDonation() {
		LocalDateTime dateTime = LocalDateTime.now().with(TemporalAdjusters.lastDayOfMonth());
		Donor anyDonor = DonorFactory.anyDonor();
		Donation lastDayOfMonthDonation = new Donation(anyDonor, 1000, dateTime,"aCommentary");
		
		return lastDayOfMonthDonation;
	}
	
	public static Donation beforeMonthDonation() {
		LocalDateTime dateTime = LocalDateTime.now().with(TemporalAdjusters.firstDayOfMonth()).minusDays(1);
		Donor anyDonor = DonorFactory.anyDonor();
		Donation beforeMonthDonation = new Donation(anyDonor, 1000, dateTime,"aCommentary");
		
		return beforeMonthDonation;
	}
	
	public static Donation afterMonthDonation() {
		LocalDateTime dateTime = LocalDateTime.now().with(TemporalAdjusters.lastDayOfMonth()).plusDays(1);
		Donor anyDonor = DonorFactory.anyDonor();
		Donation afterMonthDonation = new Donation(anyDonor, 1000, dateTime,"aCommentary");
		
		return afterMonthDonation;
	}
}
