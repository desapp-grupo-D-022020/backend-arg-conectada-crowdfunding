package ar.edu.unq.desapp.grupod.argconectadabackend.dto;

public class InfoDonationDTO {
	private double points;

	private String projectName;
	
	private double amount;

	private String date;

	public InfoDonationDTO(double points, String projectName, double amount, String date) {
		this.points = points;
		this.projectName = projectName;
		this.amount = amount;
		this.date = date;
	}
	
	public double getPoints() {
		return points;
	}

	public void setPoints(double points) {
		this.points = points;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
}
