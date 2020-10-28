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
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import ar.edu.unq.desapp.grupod.argconectadabackend.utils.ImageConverter;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@NotBlank(message = "User name cannot be null and must have at least one character")
	@Size(min = 5, max = 50, message = "User name must be between 5 and 50 characters")
	@Column(length=50)
	private String name;
	
	@NotBlank(message = "User password cannot be null and must have at least one character")
	@Size(min = 8, max = 50, message = "User password must be between 8 and 50 characters")
	@Column(name = "pwd")
	private String password;
	@NotNull(message = "User email cannot be null")
	@Email(message = "User email should be valid")
	@Size(min = 5, max = 50, message = "User email must be between 5 and 50 characters")
	@Column(unique = true)
	private String email;
	
    @ManyToMany
    @JoinTable(name = "user_rol", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "rol_id"))
    private Set<Rol> roles = new HashSet<>();
    
	@PositiveOrZero(message = "User points cannot be negative")
	@Column
	private Double points;
	
	@NotNull(message = "User rewardProgram cannot be null")
	@Transient
	private RewardProgram rewardProgram;
	
    @ElementCollection
    @CollectionTable(name = "user_points_mapping", joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")})
    @MapKeyColumn(name = "project_name")
    @Column(name = "points")
	private Map<String, Double> pointsRegistry = new HashMap<String, Double>();
    
    @NotBlank(message = "User nickname cannot be null and must have at least one character")
	@Column(unique = true)
	private String userName;
	
	@Lob
	@Column
	private byte[] img;
		
	public User() {}
	
	public User(@NotBlank String name, String password, String email, String userName) {
		this.name = name;
		this.password = password;
		this.email = email;
		this.points = 0.0;
		this.userName = userName;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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
