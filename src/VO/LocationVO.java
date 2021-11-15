package VO;

public class LocationVO {

	private int locationID;
	private LoginVO loginvo;
	private float latitude;
	private float longitude;
	private String status;
	private AmbulanceVO ambulanceVO;
	private HospitalVO hvo;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public AmbulanceVO getAmbulanceVO() {
		return ambulanceVO;
	}
	public void setAmbulanceVO(AmbulanceVO ambulanceVO) {
		this.ambulanceVO = ambulanceVO;
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
	public int getLocationID() {
		return locationID;
	}
	public void setLocationID(int locationID) {
		this.locationID = locationID;
	}
	public LoginVO getLoginvo() {
		return loginvo;
	}
	public void setLoginvo(LoginVO loginvo) {
		this.loginvo = loginvo;
	}
	public HospitalVO getHvo() {
		return hvo;
	}
	public void setHvo(HospitalVO hvo) {
		this.hvo = hvo;
	}
	
	
	
	}


