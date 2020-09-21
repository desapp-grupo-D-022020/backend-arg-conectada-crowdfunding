package ar.edu.unq.desapp.grupod.argconectadabackend.model;

import java.util.List;

public class CrowdFundingManager {
	
	private List<Place> places;
	
	private ProjectManager projectManager;
	
	private List<Donor> users;
	
	public CrowdFundingManager() { }

	public CrowdFundingManager(List<Place> places, List<Donor> users) {
		this.places = places;
		this.users = users;
	}

	public List<Place> getPlaces() {
		return places;
	}

	public void setPlaces(List<Place> places) {
		this.places = places;
	}

	public ProjectManager getProjectManager() {
		return this.projectManager;
	}

	public void setProjectManager(ProjectManager projectManager) {
		this.projectManager = projectManager;
	}

	public List<Donor> getUsers() {
		return users;
	}

	public void setUsers(List<Donor> users) {
		this.users = users;
	}
	
	public List<Project> getOpenProjects() {
		return this.projectManager.getOpenProjects();
	}
	
	public List<Project> getNearlyCloseProjects() {
		return this.projectManager.getNearlyCloseProjects();
	}
	
	public Project getProject(Place place) {
		return this.projectManager.getProject(place); 
	}
	
	public double getCost(Place place) {
		return this.projectManager.getCost(place);
	}
	
	public List<Project> topTenProjectsWithMoreTimeWithoutDonations() {
		return this.projectManager.getTopTenProjectsWithMoreTimeWithoutDonations();
	}
	
	public List<Donation> topTenDonations() {
		return this.projectManager.getTopTenDonations();
	}
}
