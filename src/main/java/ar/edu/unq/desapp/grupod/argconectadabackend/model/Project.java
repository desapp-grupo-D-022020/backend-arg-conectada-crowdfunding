package ar.edu.unq.desapp.grupod.argconectadabackend.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Project {

	private String name;
	
	private Place place;

	private double factor;

	private double percentageForClose;

	private LocalDateTime startDate;

	private LocalDateTime endDate;
	
	private List<Donation> donations;
	
	private List<Donor> donors;
	
	private PointsManager pointManager;
	
	private Boolean isOpen;

	public Project(Place place, String nameOfProject, LocalDateTime startDate, LocalDateTime endDate) {
		this.factor = 1000;
		this.percentageForClose = 100;
		this.name = nameOfProject;
		this.startDate = startDate;
		this.endDate = endDate;
		this.isOpen = true;
		this.donations = new ArrayList<Donation>();
		this.donors = new ArrayList<Donor>();
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
		return this.donors;
	}
	
	public List<Donation> getDonations() {
		return donations;
	}

	public void setDonations(List<Donation> donations) {
		this.donations = donations;
	}
	
	public void addDonor(Donor donor) {
		this.donors.add(donor);
	}
	
	public double getCost() {
		return place.getPopulation() * this.factor;
	}

	public int getPlacePopulation() {
		return this.place.getPopulation();
	}

	private void assignPointsToUser(Donor user, Project project, double amount) {
		this.pointManager.assignPoints(user, project, amount);
	}
	
	public void receiveDonation(Donor user, double amount, String commentary) {
		LocalDateTime date = LocalDateTime.now();
		this.donations.add(new Donation(user.getNickName(), amount, date, commentary));
		this.addDonor(user);
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
