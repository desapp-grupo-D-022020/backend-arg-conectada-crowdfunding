package ar.edu.unq.desapp.grupod.argconectadabackend.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.TemporalAdjusters;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Donation {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@OneToOne(cascade=CascadeType.ALL) 	
	@JoinColumn(name="donor_id")
	private Donor donor;
	@Column
	private double amount;
	@Column
	private LocalDateTime date;
	@Column
	private String commentary;
	
	public Donation() {}
	
	public Donation(Donor donor, double amount, LocalDateTime date, String commentary) {
		this.donor = donor;
		this.amount = amount;
		this.date = date;
		this.commentary = commentary;
	}

	public String getNickNameUser() {
		return this.donor.getNickName();
	}

	public double getAmount() {
		return amount;
	}
	
	public Donor getDonor() {
		return this.donor;
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
