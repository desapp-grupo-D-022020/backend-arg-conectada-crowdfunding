package ar.edu.unq.desapp.grupod.argconectadabackend.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String name;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "place_id")
	private Place place;
	
	@Column
	private double factor;
	
	@Column
	private double percentageForClose;
	
	@Column
	private LocalDateTime startDate;
	
	@Column
	private LocalDateTime endDate;
	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH })
	@JoinColumn(name = "project_id")
	private List<Donation> donations;
	
	@Column
	private Boolean isOpen;
	
	public Project() {}

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
	
	public int getId() {
		return this.id;
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

	public List<User> getDonors() {
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

	public void receiveDonation(User user, double amount, String commentary) {
		LocalDateTime date = LocalDateTime.now();
		this.donations.add(new Donation(user, amount, date, commentary));
	}

	public Donation getLastDonation() {
		if (donations.size()>1)
		{
			return donations.get(donations.size() - 1);
		}
		else {
			return DonationFactory.emptyDonation();
		}
		
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

	public boolean hasDonationsOnCurrentMonth() {
		Donation lastDonation = this.getLastDonation();
		return lastDonation.isWithinCalendarMonth();
	}
}
