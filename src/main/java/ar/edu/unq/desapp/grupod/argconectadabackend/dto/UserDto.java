package ar.edu.unq.desapp.grupod.argconectadabackend.dto;

public class UserDto {

	private int id;
	
	private String name;

	private String userName;
	
	private String email;

    private Double points;
    
    private byte[] img;
    
	public UserDto(int id, String name, String userName, String email, Double points, byte[] img) {
		this.id = id;
		this.name = name;
		this.userName = userName;
		this.email = email;
		this.points = points;
		this.img = img;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public byte[] getImg() {
		return img;
	}

	public void setImg(byte[] img) {
		this.img = img;
	}
	
}
