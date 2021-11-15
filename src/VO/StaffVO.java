package VO;

public class StaffVO {

private int serialNo;	
private String firstName;	
private String lastName;
private String birthDate;

private String contactNo;
private String gender;
private String post;
private StateVO statevo;
private CityVO cityvo;
private AreaVO areavo;
private AmbulanceVO avo;
private String deleteStatus;
private LoginVO loginvo;
public int getSerialNo() {
	return serialNo;
}
public void setSerialNo(int serialNo) {
	this.serialNo = serialNo;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getBirthDate() {
	return birthDate;
}
public void setBirthDate(String birthDate) {
	this.birthDate = birthDate;
}
public String getContactNo() {
	return contactNo;
}
public void setContactNo(String contactNo) {
	this.contactNo = contactNo;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getPost() {
	return post;
}
public void setPost(String post) {
	this.post = post;
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
public AmbulanceVO getAvo() {
	return avo;
}
public void setAvo(AmbulanceVO avo) {
	this.avo = avo;
}
public String getDeleteStatus() {
	return deleteStatus;
}
public void setDeleteStatus(String deleteStatus) {
	this.deleteStatus = deleteStatus;
}
public LoginVO getLoginvo() {
	return loginvo;
}
public void setLoginvo(LoginVO loginvo) {
	this.loginvo = loginvo;
}


}