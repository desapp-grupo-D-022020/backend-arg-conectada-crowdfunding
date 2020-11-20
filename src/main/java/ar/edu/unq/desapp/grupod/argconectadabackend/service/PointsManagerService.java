package ar.edu.unq.desapp.grupod.argconectadabackend.service;

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

	public double calculatePoints(User donor, Project project, double amount) {
		int population = project.getPlacePopulation();
		double points = 0;
		if (amount > 1000)
			points += amount;
			
		if (population < 2000)
			points += amount * 2;

		if (project.hasDonationsOnCurrentMonth())
			points += 500.0;
		  return points;
	}
	
	public double assignPoints(User donor, Project project, double donationAmount) {
		double pointsToAssign =this.calculatePoints(donor, project, donationAmount);
		donor.addPoints(pointsToAssign);
		return pointsToAssign;
	}
}
