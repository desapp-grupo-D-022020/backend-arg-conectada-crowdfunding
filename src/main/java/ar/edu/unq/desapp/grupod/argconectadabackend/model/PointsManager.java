package ar.edu.unq.desapp.grupod.argconectadabackend.model;

import java.util.ArrayList;
import java.util.List;

/*
 * The points manager responsability is only to calculate
 * the points obtained as a result of a donation
 * 
 */
public class PointsManager {

	public List<Double> calculatePoints(Donor donor, Project project, double amount) {
		int population = project.getPlacePopulation();
		List<Double> pointsList = new ArrayList<Double>();
		
		if (amount > 1000)
			pointsList.add(amount);
			
		if (population < 2000)
			pointsList.add(amount * 2);			

		if (hasDonationsOnCurrentMonth(donor, project))
			pointsList.add(500.0);
			
		return pointsList;
	}
	
	public Double sumPoints(List<Double> pointsList) {
		return pointsList.stream().mapToDouble(f -> f.doubleValue()).sum();
	}
	
	public void assignPoints(Donor donor, Project project, double donationAmount) {
		String nameOfProject = project.getName();
		List<Double> pointsToAssign = calculatePoints(donor, project, donationAmount);
		donor.addPointsToRegister(nameOfProject, sumPoints(pointsToAssign));
	}

	//FIXME: no usa el user, consultar donde tiene que preguntar esto
	private boolean hasDonationsOnCurrentMonth(Donor user, Project project) {
		Donation lastDonation = project.getLastDonation();
		return lastDonation.isWithinCalendarMonth();
	}
}
