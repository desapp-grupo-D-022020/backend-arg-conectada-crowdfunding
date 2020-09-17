package ar.edu.unq.desapp.grupod.argconectadabackend.model;

public class PointManager {

	public void assignPoints(Donor user, Project project, double amount) {
		int points = 0;
		int population = project.getPlacePopulation();
		String nameOfProject = project.getName();
		
		if (amount > 1000)
			points += amount;
			user.addPointsToRegister(nameOfProject, points);
			
		if (population < 2000)
			points += amount * 2;
			user.addPointsToRegister(nameOfProject, points);
			

		if (hasDonationsOnCurrentMonth(user, project))
			points += 500;
			user.addPointsToRegister(nameOfProject, points);
			
		user.addPoints(points);
	}

	private boolean hasDonationsOnCurrentMonth(Donor user, Project project) {
		Donation lastDonation = project.getLastDonation();
		return lastDonation.isWithinCalendarMonth();
	}
}
