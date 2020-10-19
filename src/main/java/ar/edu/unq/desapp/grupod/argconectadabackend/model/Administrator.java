package ar.edu.unq.desapp.grupod.argconectadabackend.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
public class Administrator extends User {

	@Transient
	private ProjectManager projectManager;

	public Administrator() {}

	public Administrator(String name, String password, String email, ProjectManager projectManager) {
		super(name, password, email);
		this.projectManager = projectManager;
	}

	public void closeProject(Project project) {
		this.projectManager.closeProject(project);
	}
	
	public void createProject(Place place, String nameOfProject, LocalDateTime startDate, LocalDateTime endDate) {
		this.projectManager.createProject(place, nameOfProject, startDate, endDate);
	}
}
