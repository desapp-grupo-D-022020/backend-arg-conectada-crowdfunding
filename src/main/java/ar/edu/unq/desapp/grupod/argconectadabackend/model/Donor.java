package ar.edu.unq.desapp.grupod.argconectadabackend.model;

import java.util.List;

public class Donor extends User {
	
	private int points;
	
	private RewardProgram rewardProgram;
	
	private List<Donation> donations;
	
	private String nickName;

	public Donor(String name, String password, String email, int points, 
			List<Donation> donations, String nickName, RewardProgram rewardProgram) {
		super(name, password, email);
		this.points = points;
		this.donations = donations;
		this.nickName = nickName;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public List<Donation> getDonations() {
		return donations;
	}

	public void setDonations(List<Donation> donations) {
		this.donations = donations;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	public void addPoints(int points) {
		this.points += points;
	}

	public RewardProgram getRewardProgram() {
		return rewardProgram;
	}

	public void setRewardProgram(RewardProgram rewardProgram) {
		this.rewardProgram = rewardProgram;
	}
}
