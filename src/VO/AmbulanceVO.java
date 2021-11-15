package VO;

public class AmbulanceVO {
	private int ambulanceNumber;
	private int modelNumber;
	private String passingYear;
	private String allocation;
	private String deleteStatus;
	private float latitude;
	private float longitude;
	
	private StateVO statevo;
	private CityVO cityvo;
	private AreaVO areavo;
	
	public String getPassingYear() {
		return passingYear;
	}
	public void setPassingYear(String passingYear) {
		this.passingYear = passingYear;
	}
	public String getAllocation() {
		return allocation;
	}
	public void setAllocation(String allocation) {
		this.allocation = allocation;
	}
	public int getAmbulanceNumber() {
		return ambulanceNumber;
	}
	public void setAmbulanceNumber(int ambulanceNumber) {
		this.ambulanceNumber = ambulanceNumber;
	}
	public int getModelNumber() {
		return modelNumber;
	}
	public void setModelNumber(int modelNumber) {
		this.modelNumber = modelNumber;
	}
	public String getDeleteStatus() {
		return deleteStatus;
	}
	public void setDeleteStatus(String deleteStatus) {
		this.deleteStatus = deleteStatus;
	}
	public StateVO getStatevo() {
		return statevo;
	}
	public void setStatevo(StateVO statevo) {
		this.statevo = statevo;
	}
	public CityVO getCityvo() {
		return cityvo;
	}
	public void setCityvo(CityVO cityvo) {
		this.cityvo = cityvo;
	}
	public AreaVO getAreavo() {
		return areavo;
	}
	public void setAreavo(AreaVO areavo) {
		this.areavo = areavo;
	}
	public float getLatitude() {
		return latitude;
	}
	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}
	public float getLongitude() {
		return longitude;
	}
	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

}
