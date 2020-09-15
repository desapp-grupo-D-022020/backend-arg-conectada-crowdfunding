package ar.edu.unq.desapp.grupod.argconectadabackend.model;

import java.time.LocalDate;

public class Donation {

	private String nickNameUser;
	
	private double amount;
	
	private LocalDate date;
	
	private String commentary;
	
	public Donation(String nickNameUser, double amount, LocalDate date, String commentary) {
		this.nickNameUser = nickNameUser;
		this.amount = amount;
		this.date = date;
		this.commentary = commentary;
	}

	public String getNickNameUser() {
		return nickNameUser;
	}

	public void setNickNameUser(String nickNameUser) {
		this.nickNameUser = nickNameUser;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getCommentary() {
		return commentary;
	}

	public void setCommentary(String commentary) {
		this.commentary = commentary;
	}

}
