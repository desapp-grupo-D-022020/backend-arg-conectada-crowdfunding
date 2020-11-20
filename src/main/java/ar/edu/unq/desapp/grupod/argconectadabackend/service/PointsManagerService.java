package ar.edu.unq.desapp.grupod.argconectadabackend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unq.desapp.grupod.argconectadabackend.model.Project;
import ar.edu.unq.desapp.grupod.argconectadabackend.model.User;

/*
 * The points manager responsability is only to calculate
 * the points obtained as a result of a donation
 * 
 */
@Service
public class PointsManagerService {

	public List<Double> calculatePoints(User donor, Project project, double amount) {
		int population = project.getPlacePopulation();
		List<Double> pointsList = new ArrayList<Double>();
		
		if (amount > 1000)
			pointsList.add(amount);
			
		if (population < 2000)
			pointsList.add(amount * 2);			

		if (project.hasDonationsOnCurrentMonth())
			pointsList.add(500.0);
			
		return pointsList;
	}
	
	public Double sumPoints(List<Double> pointsList) {
		return pointsList.stream().mapToDouble(f -> f.doubleValue()).sum();
	}
	
	public void assignPoints(User donor, Project project, double donationAmount) {
		String nameOfProject = project.getName();
		List<Double> pointsToAssign = this.calculatePoints(donor, project, donationAmount);
		donor.addPointsToRegister(nameOfProject, this.sumPoints(pointsToAssign));
	}
}
