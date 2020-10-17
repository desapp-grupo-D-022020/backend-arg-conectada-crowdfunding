package ar.edu.unq.desapp.grupod.argconectadabackend.model;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "donor")
public class Donor extends User {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column(name = "points")
	private Double points;
	//@OneToOne(mappedBy = "donor")
	@Transient
	private RewardProgram rewardProgram;
	@Transient
	private Map<String, Double> pointsRegistry = new HashMap<String, Double>();
	@Column(name = "nickName")
	private String nickName;
	
	public Donor() {}

	public Donor(String name, String password, String email, String nickName) {
		super(name, password, email);
		this.points = 0.0;
		this.nickName = nickName;
		this.rewardProgram = new RewardProgram();
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
	
	public Map<String, Double> getPointsRegistry() {
		return this.pointsRegistry;
	}
	
	public void addPoints(double points) {
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
	
	public void donate(double amount, String commentary, Project project) {
		project.receiveDonation(this , amount, commentary);
	}
}
