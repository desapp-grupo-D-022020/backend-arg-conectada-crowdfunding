package ar.edu.unq.desapp.grupod.argconectadabackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Place {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@NotBlank(message = "Place name cannot be null and must have at least one character")
	@Column
	private String name;
	
	@NotBlank(message = "Place province cannot be null and must have at least one character")
	@Column
	private String province;
	
	@Column
	private int population;
	
	@NotBlank(message = "Place status cannot be null and must have at least one character")
	@Column
	private String status;
	
	public Place() {}
	
	public Place(String name, String province, int population, String status) {
		this.name = name;
		this.province = province;
		this.population = population;
		this.status = status;
	}
	
	public int getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public int getPopulation() {
		return this.population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
