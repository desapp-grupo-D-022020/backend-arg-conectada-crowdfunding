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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@OneToOne(cascade=CascadeType.ALL) 	
	@JoinColumn(name="donor_id")
	private User donor;
	@Column
	private String projectName;
	@Column
	private double points;
	@Column
	private double amount;
	@Column
	private LocalDateTime date;
	@Column
	private String comment;
	
	public Donation() {}
	
	public Donation(User donor, String projectName, double points, double amount, LocalDateTime date, String comment) {
		this.donor = donor;
		this.projectName = projectName;
		this.points = points;
		this.amount = amount;
		this.date = date;
		this.comment = comment;
	}
	
	public int getId() {
		return this.id;
	}

	public String getUserName() {
		return this.donor.getUserName();
	}

	public double getAmount() {
		return amount;
	}
	
	public double getPoints() {
		return points;
	}

	public void setPoints(double points) {
		this.points = points;
	}
	
	public User getDonor() {
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

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
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
