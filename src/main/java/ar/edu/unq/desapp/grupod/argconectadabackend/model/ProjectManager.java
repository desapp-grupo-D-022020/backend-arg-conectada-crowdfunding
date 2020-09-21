package ar.edu.unq.desapp.grupod.argconectadabackend.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProjectManager {
	
	private List<Project> projects;
	
	public ProjectManager(List<Project> projects) {
		this.projects = projects;
	}
	
	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	
	public List<Project> getOpenProjects() {
		int currentMonth = LocalDateTime.now().getMonthValue();
		return this.projects.stream().filter(project -> project.getEndDate().getMonthValue() > currentMonth).collect(Collectors.toList());
	}
	
	public List<Project> getNearlyCloseProjects() {
		int currentMonth = LocalDateTime.now().getMonthValue();
		return this.projects.stream().filter(project -> project.getEndDate().getMonthValue() == currentMonth).collect(Collectors.toList());
	}
	
	public Project getProject(Place place) {
		return this.projects.stream().filter(project -> project.getPlace().equals(place)).collect(Collectors.toList()).get(0); 
	}
	
	public double getCost(Place place) {
		return this.getProject(place).getCost();
	}

	public void createProject(Place place, String nameOfProject, LocalDateTime startDate, LocalDateTime endDate) {
		this.projects.add(new Project(place, nameOfProject, startDate, endDate));
	}

	public void closeProject(Project project) {
		 project.closeProject();
	}
	
	public List<Project> getTopTenProjectsWithMoreTimeWithoutDonations() {
		List<Project> topTen = new ArrayList<Project>();
		List<Project> projects = this.getProjects();
		while(topTen.size() < 10) {
			Project projectToAdd = this.getProjectWithMoreTimeWithoutDonations(projects);
			topTen.add(projectToAdd);
			projects.remove(projectToAdd);
		}
		return topTen;
	}

	private Project getProjectWithMoreTimeWithoutDonations(List<Project> projects) {
		Project projectWithMoreTimeWithoutDonations = projects.remove(0);
		for(Project project : projects) {
			if( project.getLastDonation().getDate().isBefore(projectWithMoreTimeWithoutDonations.getLastDonation().getDate())) {
				projectWithMoreTimeWithoutDonations = project;
			}
		}
		return projectWithMoreTimeWithoutDonations;
	}
	
	public List<Donation> getTopTenDonations() {
		List<Donation> topTen = new ArrayList<Donation>();
		List<Project> projects = this.getProjects();
		while(topTen.size() < 10) {
			Project projectWithLargestDonation = this.getProjectWithLargestDonation(projects);
			Donation donationToAdd = this.getBiggestDonation(projectWithLargestDonation.getDonations());
			topTen.add(donationToAdd);
			projects.remove(projectWithLargestDonation);
		}
		return topTen;
	}

	private Project getProjectWithLargestDonation(List<Project> projects) {
		Project projectWithLargestDonation = projects.remove(0);
		for(Project project : projects) {
			if( this.getAmounFromBiggestDonation(project.getDonations()) > this.getAmounFromBiggestDonation(projectWithLargestDonation.getDonations())) {
				projectWithLargestDonation = project;
			}
		}
		return projectWithLargestDonation;
	}
	
	private Donation getBiggestDonation(List<Donation> donations) {
		Donation biggestDonation = donations.remove(0);
		for(Donation donation : donations) {
			if( donation.getAmount() > biggestDonation.getAmount()) {
				biggestDonation = donation;
			}
		}
		return biggestDonation;
	}
	
	private double getAmounFromBiggestDonation(List<Donation> donations) {
		return this.getBiggestDonation(donations).getAmount();
	}
}
