package ar.edu.unq.desapp.grupod.argconectadabackend.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class Project {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column
	private String name;
	//@Column
	@Transient
	private Place place;
	@Column
	private double factor;
	@Column
	private double percentageForClose;
	@Column
	private LocalDateTime startDate;
	@Column
	private LocalDateTime endDate;
	//@OneToMany
	//@JoinColumn(name = "project_id", referencedColumnName = "id")
	@Transient
	private List<Donation> donations;
	@Transient
	private PointsManager pointsManager;
	@Column
	private Boolean isOpen;

	public Project(Place place, String nameOfProject, LocalDateTime startDate, LocalDateTime endDate) {
		this.place = place;
		this.factor = 1000;
		this.percentageForClose = 100;
		this.name = nameOfProject;
		this.startDate = startDate;
		this.endDate = endDate;
		this.isOpen = true;
		this.donations = new ArrayList<Donation>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}

	public double getFactor() {
		return factor;
	}
	
	public void setPointsManager(PointsManager pointsManager) {
		this.pointsManager = pointsManager;
	}

	public void setFactor(double factor) {
		this.factor = factor;
	}

	public double getPercentageForClose() {
		return percentageForClose;
	}

	public void setPercentageForClose(double percentageForClose) {
		this.percentageForClose = percentageForClose;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}

	public List<Donor> getDonors() {
		return this.donations.stream().map(donation -> donation.getDonor()).collect(Collectors.toList());
	}
	
	public List<Donation> getDonations() {
		return donations;
	}

	public void setDonations(List<Donation> donations) {
		this.donations = donations;
	}
	
	public double getCost() {
		return place.getPopulation() * this.factor;
	}

	public int getPlacePopulation() {
		return this.place.getPopulation();
	}

	private void assignPointsToUser(Donor user, Project project, double amount) {
		this.pointsManager.assignPoints(user, project, amount);
	}
	
	public void receiveDonation(Donor user, double amount, String commentary) {
		LocalDateTime date = LocalDateTime.now();
		this.donations.add(new Donation(user, amount, date, commentary));
		this.assignPointsToUser(user, this, amount);
	}
	
	public Donation getLastDonation() {
		return donations.get(donations.size()-1);
	}
	
	public LocalDateTime getLastDonationDate() {
		return this.getLastDonation().getDate();
	}
	
	public boolean isOpen() {
		return this.isOpen;
	}
	
	public void closeProject() {
		this.isOpen = false;
	}
	

}
