package ar.edu.unq.desapp.grupod.argconectadabackend.model;

import java.util.HashMap;
import java.util.Map;

public class Donor extends User {
	
	private Double points;
	
	private RewardProgram rewardProgram;
	
	private Map<String, Double> pointsRegistry = new HashMap<String, Double>();
	
	private String nickName;

	public Donor(String name, String password, String email, String nickName, RewardProgram rewardProgram) {
		super(name, password, email);
		this.points = 0.0;
		this.nickName = nickName;
	}

	public Double getPoints() {
		return points;
	}

	public void setPoints(Double points) {
		this.points = points;
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
	
	public void addPointsToRegister(String nameOfProject, Double points) {
		this.pointsRegistry.put(nameOfProject, points);
	}

	public RewardProgram getRewardProgram() {
		return rewardProgram;
	}

	public void setRewardProgram(RewardProgram rewardProgram) {
		this.rewardProgram = rewardProgram;
	}
}
