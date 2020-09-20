package ar.edu.unq.desapp.grupod.argconectadabackend.model;

import java.time.LocalDateTime;
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
}
