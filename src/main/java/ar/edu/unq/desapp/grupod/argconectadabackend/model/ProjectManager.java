package ar.edu.unq.desapp.grupod.argconectadabackend.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.unq.desapp.grupod.argconectadabackend.service.EmailSender;

public class ProjectManager {
	
	@Autowired
	private EmailSender emailSender;
	
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
		List<Donor> donors = project.getDonors();
		for(Donor donor : donors) {
			this.emailSender.closeProyectEmail(donor.getEmail(), donor.getNickName());
		}
	}
	
	public List<Project> getTopTenProjectsWithMoreTimeWithoutDonations() {
		List<Project> topTen = new ArrayList<Project>();
		List<Project> projects = this.getProjects();
		while(topTen.size() < 10 && !projects.isEmpty()) {
			Project projectToAdd = this.getProjectWithMoreTimeWithoutDonations(projects);
			topTen.add(projectToAdd);
			projects.remove(projectToAdd);
		}
		return topTen;
	}

	private Project getProjectWithMoreTimeWithoutDonations(List<Project> projects) {
		Project projectWithMoreTimeWithoutDonations = projects.remove(0);
		for(Project project : projects) 
			if(project.getLastDonationDate().isBefore(projectWithMoreTimeWithoutDonations.getLastDonationDate()))
				projectWithMoreTimeWithoutDonations = project;
		
		return projectWithMoreTimeWithoutDonations;
	}
	
	private int compare(Donation aDonation, Donation otherDonation) {
		Double anAmount = aDonation.getAmount();
		Double otherAmount = otherDonation.getAmount();
		if (anAmount == otherAmount) return 0;
		else return anAmount > otherAmount ? -1 : 1;
	}
		
	public List<Donation> getTopTenDonations() {
		List<Project> projects = this.getProjects();
		
		return projects.stream().map(project -> project.getDonations()).flatMap(Collection::stream)
				.sorted(this::compare)
				.limit(10)
				.collect(Collectors.toList());
	}
}
