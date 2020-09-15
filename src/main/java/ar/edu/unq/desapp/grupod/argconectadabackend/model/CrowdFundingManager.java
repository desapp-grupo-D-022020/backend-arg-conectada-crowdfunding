package ar.edu.unq.desapp.grupod.argconectadabackend.model;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class CrowdFundingManager {
	
	private List<Place> places;
	
	private List<Project> projects;
	
	private List<Donor> users;
	
	private PointManager pointManager;
	
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
	
	public double getCost(Place place) {
		return this.projects.stream().filter(project -> project.getPlace().equals(place)).collect(Collectors.toList()).get(0).getCost();
	}
	
	private void assignPointsToUser(Donor user, Project project, double amount) {
		this.pointManager.assigPoints(user, project, amount);
	}
	
	public void donate(Donor user, double amount, String commentary, LocalDate date, Project project) {
		project.receiveDonation(user.getNickName() , amount, date, commentary);
		this.assignPointsToUser(user, project, amount);
	}
}
