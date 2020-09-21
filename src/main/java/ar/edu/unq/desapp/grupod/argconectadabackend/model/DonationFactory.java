package ar.edu.unq.desapp.grupod.argconectadabackend.model;

import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

public class DonationFactory {
	
	public static Donation anyDonation() {
		LocalDateTime dateTime = LocalDateTime.now();
		Donation anyDonation = new Donation("aNickname", 1000, dateTime,"aCommentary");
		
		return anyDonation;
	}
	
	public static Donation firstDayOfMonthDonation() {
		LocalDateTime dateTime = LocalDateTime.now().with(TemporalAdjusters.firstDayOfMonth());
		Donation firstDayOfMonthDonation = new Donation("aNickname", 1000, dateTime,"aCommentary");
		
		return firstDayOfMonthDonation;
	}
	
	public static Donation lastDayOfMonthDonation() {
		LocalDateTime dateTime = LocalDateTime.now().with(TemporalAdjusters.lastDayOfMonth());
		Donation lastDayOfMonthDonation = new Donation("aNickname", 1000, dateTime,"aCommentary");
		
		return lastDayOfMonthDonation;
	}
	
	public static Donation beforeMonthDonation() {
		LocalDateTime dateTime = LocalDateTime.now().with(TemporalAdjusters.firstDayOfMonth()).minusDays(1);
		Donation beforeMonthDonation = new Donation("aNickname", 1000, dateTime,"aCommentary");
		
		return beforeMonthDonation;
	}
	
	public static Donation afterMonthDonation() {
		LocalDateTime dateTime = LocalDateTime.now().with(TemporalAdjusters.lastDayOfMonth()).plusDays(1);
		Donation afterMonthDonation = new Donation("aNickname", 1000, dateTime,"aCommentary");
		
		return afterMonthDonation;
	}
}
