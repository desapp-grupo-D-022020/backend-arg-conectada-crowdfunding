package ar.edu.unq.desapp.grupod.argconectadabackend.dto;

public class ProjectDTO {
	
	private String placeId;
	
	private String name;
	
	private String startDate;
	
	private String endDate;
	
	private String factor;
	
	private String percentageForClose;

	public String getPlaceId() {
		return placeId;
	}

	public void setPlaceId(String placeId) {
		this.placeId = placeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getFactor() {
		return factor;
	}

	public void setFactor(String factor) {
		this.factor = factor;
	}

	public String getPercentageForClose() {
		return percentageForClose;
	}

	public void setPercentageForClose(String percentageForClose) {
		this.percentageForClose = percentageForClose;
	}
}
