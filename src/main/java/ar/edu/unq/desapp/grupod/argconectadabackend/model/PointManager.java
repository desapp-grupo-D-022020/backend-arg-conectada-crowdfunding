package ar.edu.unq.desapp.grupod.argconectadabackend.model;

public class PointManager {

	public void assigPoints(Donor user, Project project, double amount) {
		int points = 0;
		int population = project.getPlacePopulation();
		if (amount > 1000)
			points += amount;
		if (population < 2000)
			points += amount * 2;
		//finalizar el flujo de la última condición
//		if (hasDonationsOnCurrentMonth(user, project))
			points += 500;
		user.addPoints(points);
	}

//	private boolean hasDonationsOnCurrentMonth(User user, Project project) {
//		return this.projects.map(project -> project.getNicknamesOfDonationsOnCurrentMonth()).flat().filter(nickname -> nickname == user.nickname).lenght > 1;
//	}
}
