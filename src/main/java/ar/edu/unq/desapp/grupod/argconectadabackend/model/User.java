package ar.edu.unq.desapp.grupod.argconectadabackend.model;

import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

public class User {
	
	private String email;
	private String password; //will be encripted and salted in the future
	private String nick;
	private int points;
	private LocalDateTime lastDonation;
	
	public User(String email, String pass, String nick, int points, LocalDateTime lastDonation) {
		this.email = email;
		this.password = pass;
		this.nick = nick;
		this.points = points;
		this.lastDonation = lastDonation;
	}
	
	public int getPoints() {
		return this.points;
	}
	
	public void addPoints(int pointsToAdd) {
		this.points = this.points + pointsToAdd;
	}

		
	public void receivePoints(int money) {
		if (money >= 1000) {
			this.addPoints(money);
		}
		
		/*if (project.place.population < 2000) {
			this.addPoints(2 * money);
		}*/
		
		if (lastDonation.isBefore(lastDonation.with(TemporalAdjusters.lastDayOfMonth())) &&
			lastDonation.isAfter(lastDonation.with(TemporalAdjusters.firstDayOfMonth()))) {
			this.addPoints(money + 500);	
		}
	}
	
	/*

	public void donate(Project project, int money, String comment) {
		project.receiveMoney(money,comment);
		this.lastDonation = LocalDateTime.now()
		this.receivePoints(money);
	}
	
	*/
	

}
