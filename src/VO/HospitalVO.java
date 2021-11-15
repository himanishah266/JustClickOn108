package VO;

public class HospitalVO {
	private int hospitalID;
	private String hospitalName;
	private String hospitalDes;
	private StateVO statevo;
	private CityVO cityvo;
	private AreaVO areavo;
	private String deleteStatus;
	private String contactNo;
	private float latitude;
	private float longitude;
	
	
	public int getHospitalID() {
		return hospitalID;
	}
	public void setHospitalID(int hospitalID) {
		this.hospitalID = hospitalID;
	}
	public String getHospitalName() {
		return hospitalName;
	}
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	public String getHospitalDes() {
		return hospitalDes;
	}
	public void setHospitalDes(String hospitalDes) {
		this.hospitalDes = hospitalDes;
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
	public String getDeleteStatus() {
		return deleteStatus;
	}
	public void setDeleteStatus(String deleteStatus) {
		this.deleteStatus = deleteStatus;
	}
	public float getLatitude() {
		return latitude;
	}
	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public float getLongitude() {
		return longitude;
	}
	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
	
	

}
