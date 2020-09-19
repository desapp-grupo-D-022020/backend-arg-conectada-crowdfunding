package ar.edu.unq.desapp.grupod.argconectadabackend.model;

import java.time.LocalDateTime;

public class Administrator extends User {

	public Administrator(String name, String password, String email) {
		super(name, password, email);
	}

	public void closeProject(Project project) {
		project.closeProject();
	}
	
	public void createProject(Place place, String nameOfProject, LocalDateTime startDate, LocalDateTime endDate) {
		
	}
}
