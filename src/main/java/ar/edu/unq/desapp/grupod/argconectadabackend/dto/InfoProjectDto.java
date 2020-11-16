package ar.edu.unq.desapp.grupod.argconectadabackend.dto;

public class InfoProjectDto {
    private int id;
    private String name;
    private String placeName;
    private String province;
    private String conectivity;
    private double raised;
    private double pct_left_to_reach_goal;
    
    public InfoProjectDto() {}
    
	public InfoProjectDto(int id, String name, String placeName, String province, String conectivity, double raised,
			double pct_left_to_reach_goal) {
		super();
		this.id = id;
		this.name = name;
		this.placeName = placeName;
		this.province = province;
		this.conectivity = conectivity;
		this.raised = raised;
		this.pct_left_to_reach_goal = pct_left_to_reach_goal;
	}

	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
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
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getConectivity() {
		return conectivity;
	}
	public void setConectivity(String conectivity) {
		this.conectivity = conectivity;
	}
	public double getRaised() {
		return raised;
	}
	public void setRaised(double raised) {
		this.raised = raised;
	}
	public double getPct_left_to_reach_goal() {
		return pct_left_to_reach_goal;
	}
	public void setPct_left_to_reach_goal(double pct_left_to_reach_goal) {
		this.pct_left_to_reach_goal = pct_left_to_reach_goal;
	}
}
