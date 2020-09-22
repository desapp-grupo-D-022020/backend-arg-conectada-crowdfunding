package ar.edu.unq.desapp.grupod.argconectadabackend.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.TemporalAdjusters;

public class Donation {

	private String nickName;
	
	private double amount;
	
	private LocalDateTime date;
	
	private String commentary;
	
	public Donation(String nickName, double amount, LocalDateTime date, String commentary) {
		this.nickName = nickName;
		this.amount = amount;
		this.date = date;
		this.commentary = commentary;
	}

	public String getNickNameUser() {
		return this.nickName;
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
		LocalDateTime lastDayOfMonth = LocalDate.now().atTime(LocalTime.MAX).with(TemporalAdjusters.lastDayOfMonth());
		LocalDateTime firstDayOfMonth = LocalDate.now().atTime(LocalTime.MIN).with(TemporalAdjusters.firstDayOfMonth());
		
		return (
			this.date.isBefore(lastDayOfMonth) &&
			this.date.isAfter(firstDayOfMonth)
		);
	}

}
