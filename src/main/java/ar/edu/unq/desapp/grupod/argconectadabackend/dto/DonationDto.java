package ar.edu.unq.desapp.grupod.argconectadabackend.dto;

import ar.edu.unq.desapp.grupod.argconectadabackend.model.User;

public class DonationDto {
	
	private int ProjectId;
	
	private User user;
	
	private double amount;
	
	private String commentary;

	public int getProjectId() {
		return ProjectId;
	}

	public void setProjectId(int projectId) {
		ProjectId = projectId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getCommentary() {
		return commentary;
	}

	public void setCommentary(String commentary) {
		this.commentary = commentary;
	}
}
