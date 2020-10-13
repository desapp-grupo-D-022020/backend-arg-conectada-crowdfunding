package ar.edu.unq.desapp.grupod.argconectadabackend.model;

import java.io.IOException;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.MappedSuperclass;

import ar.edu.unq.desapp.grupod.argconectadabackend.utils.ImageConverter;

@MappedSuperclass
public abstract class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column(name = "name", length=50)
	private String name;
	@Column(name = "pwd")
	private String password;
	@Column
	private String email;
	@Lob
	@Column
	private byte[] img;
	
	public User(String name, String password, String email) {
		this.name = name;
		this.password = password;
		this.email = email;
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
	
	public void setImg(String img) throws IOException { this.img = (new ImageConverter(img, "png")).imageToByteArray(); }
	
	public byte[] getImg() { return this.img; }
}
