package ar.edu.unq.desapp.grupod.argconectadabackend.model;

import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

public class Donation {

	private Donor donor;
	
	private double amount;
	
	private LocalDateTime date;
	
	private String commentary;
	
	public Donation(Donor donor, double amount, LocalDateTime date, String commentary) {
		this.donor = donor;
		this.amount = amount;
		this.date = date;
		this.commentary = commentary;
	}

	public String getNickNameUser() {
		return donor.getNickName();
	}
	
	public Donor getDonor() {
		return this.donor;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public String getCommentary() {
		return commentary;
	}

	public void setCommentary(String commentary) {
		this.commentary = commentary;
	}
	
	public Boolean isWithinCalendarMonth() {
		return (
			this.date.isBefore(LocalDateTime.now().with(TemporalAdjusters.lastDayOfMonth())) &&
			this.date.isAfter(LocalDateTime.now().with(TemporalAdjusters.firstDayOfMonth()))
		);
	}

}
