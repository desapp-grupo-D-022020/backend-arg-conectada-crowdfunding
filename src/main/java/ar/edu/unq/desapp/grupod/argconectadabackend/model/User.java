package ar.edu.unq.desapp.grupod.argconectadabackend.model;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.MapKeyColumn;
import javax.persistence.Transient;

import ar.edu.unq.desapp.grupod.argconectadabackend.utils.ImageConverter;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column(length=50)
	private String name;
	@Column(name = "pwd")
	private String password;
	@Column(unique = true)
	private String email;
    @ManyToMany
    @JoinTable(name = "usuario_rol", joinColumns = @JoinColumn(name = "usuario_id"), inverseJoinColumns = @JoinColumn(name = "rol_id"))
    private Set<Rol> roles = new HashSet<>();
	@Column
	private Double points;
	@Transient
	private RewardProgram rewardProgram;
    @ElementCollection
    @CollectionTable(name = "user_points_mapping", 
      joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")})
    @MapKeyColumn(name = "project_name")
    @Column(name = "points")
	private Map<String, Double> pointsRegistry = new HashMap<String, Double>();
	@Column(unique = true)
	private String nickName;
	@Lob
	@Column
	private byte[] img;
		
	public User() {}
	
	public User(String name, String password, String email, String nickName) {
		this.name = name;
		this.password = password;
		this.email = email;
		this.points = 0.0;
		this.nickName = nickName;
		this.rewardProgram = new RewardProgram();
	}
	
	public int getId() {
		return this.id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
	
	public void setImg(String img) throws IOException {
		this.img = (new ImageConverter(img, "png")).imageToByteArray();
	}
	
	public byte[] getImg() {
		return this.img; 
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
	
    public Set<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Set<Rol> roles) {
        this.roles = roles;
    }
}
