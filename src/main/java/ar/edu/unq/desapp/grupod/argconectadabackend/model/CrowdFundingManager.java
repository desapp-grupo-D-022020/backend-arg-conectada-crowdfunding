package ar.edu.unq.desapp.grupod.argconectadabackend.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class CrowdFundingManager {
	
	private List<Place> places;
	
	private List<Project> projects;
	
	private List<Donor> users;
	
	public CrowdFundingManager() { }

	public CrowdFundingManager(List<Place> places, List<Project> projects, List<Donor> users) {
		this.places = places;
		this.projects = projects;
		this.users = users;
	}

	public List<Place> getPlaces() {
		return places;
	}

	public void setPlaces(List<Place> places) {
		this.places = places;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public List<Donor> getUsers() {
		return users;
	}

	public void setUsers(List<Donor> users) {
		this.users = users;
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
}
