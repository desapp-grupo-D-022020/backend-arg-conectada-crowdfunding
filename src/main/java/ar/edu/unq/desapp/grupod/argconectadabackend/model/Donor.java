package ar.edu.unq.desapp.grupod.argconectadabackend.model;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.unq.desapp.grupod.argconectadabackend.service.EmailSender;

public class Donor extends User implements Observer {
	
	@Autowired
	private EmailSender emailSender;
	
	private int points;
	
	private RewardProgram rewardProgram;
	
	private Map<String, Integer> pointsRegistry = new HashMap<String, Integer>();
	
	private String nickName;

	public Donor(String name, String password, String email, String nickName, RewardProgram rewardProgram) {
		super(name, password, email);
		this.points = 0;
		this.nickName = nickName;
	}

	public Donor(String name, String password, String email, String nickName) {
		super(name, password, email);
		this.points = 0;
		this.nickName = nickName;
		this.rewardProgram = new RewardProgram();
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
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
	
	public void addPointsToRegister(String nameOfProject, int points) {
		this.pointsRegistry.put(nameOfProject, points);
	}

	public RewardProgram getRewardProgram() {
		return rewardProgram;
	}

	public void setRewardProgram(RewardProgram rewardProgram) {
		this.rewardProgram = rewardProgram;
	}
	
	public void donate(double amount, String commentary, Project project) {
		project.receiveDonation(this , amount, LocalDateTime.now(), commentary);
	}

	@Override
	public void update() {
		this.emailSender.closeProyectEmail(this.getEmail(), this.getNickName());
	}
}
