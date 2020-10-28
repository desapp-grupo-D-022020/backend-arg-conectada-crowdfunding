package ar.edu.unq.desapp.grupod.argconectadabackend.dto;

import java.time.LocalDateTime;

import ar.edu.unq.desapp.grupod.argconectadabackend.model.Place;

public class ProjectDto {
	
	private Place place;
	
	private String nameOfProject;
	
	private LocalDateTime startDate;
	
	private LocalDateTime endDate;

	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}

	public String getNameOfProject() {
		return nameOfProject;
	}

	public void setNameOfProject(String nameOfProject) {
		this.nameOfProject = nameOfProject;
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

}
